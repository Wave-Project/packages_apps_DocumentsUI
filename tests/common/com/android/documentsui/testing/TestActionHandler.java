/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.documentsui.testing;

import android.content.Intent;

import com.android.documentsui.AbstractActionHandler;
import com.android.documentsui.TestActivity;
import com.android.documentsui.base.RootInfo;
import com.android.documentsui.dirlist.DocumentDetails;

public class TestActionHandler extends AbstractActionHandler<TestActivity> {

    public final TestEventHandler<DocumentDetails> open = new TestEventHandler<>();
    public final TestEventHandler<DocumentDetails> view = new TestEventHandler<>();
    public final TestEventHandler<DocumentDetails> preview = new TestEventHandler<>();
    public boolean mDeleteHappened;

    public TestActionHandler() {
        this(TestEnv.create());
    }

    public TestActionHandler(TestEnv env) {
        super(
                TestActivity.create(),
                env.state,
                env.roots,
                env.docs,
                env.selectionMgr,
                env.searchViewManager,
                (String authority) -> null);
    }

    @Override
    public boolean openDocument(DocumentDetails doc) {
        return open.accept(doc);
    }

    @Override
    public boolean viewDocument(DocumentDetails doc) {
        return view.accept(doc);
    }

    @Override
    public boolean previewDocument(DocumentDetails doc) {
        return preview.accept(doc);
    }

    @Override
    public void deleteSelectedDocuments() {
        mDeleteHappened = true;
    }

    @Override
    public void openRoot(RootInfo root) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void initLocation(Intent intent) {
        throw new UnsupportedOperationException();
    }
}
