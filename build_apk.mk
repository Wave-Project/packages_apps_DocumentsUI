LOCAL_MODULE_TAGS := optional
LOCAL_PRIVILEGED_MODULE := true

LOCAL_STATIC_JAVA_LIBRARIES += guava

LOCAL_STATIC_ANDROID_LIBRARIES := \
        android-support-core-ui \
        android-support-v4 \
        android-support-v7-appcompat \
        android-support-v13 \
        $(ANDROID_SUPPORT_DESIGN_TARGETS) \
        android-support-transition \
        android-support-v7-recyclerview

LOCAL_USE_AAPT2 := true

LOCAL_CERTIFICATE := platform
LOCAL_PROGUARD_FLAG_FILES := proguard.flags

include $(BUILD_PACKAGE)
