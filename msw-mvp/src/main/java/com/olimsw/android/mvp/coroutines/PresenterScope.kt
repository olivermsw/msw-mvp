package com.olimsw.android.mvp.coroutines

import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.coroutineScope
import com.olimsw.android.mvp.MSWPresenter

val MSWPresenter<*>.lifeScope: LifecycleCoroutineScope
    get() = lifecycleOwner!!.lifecycle.coroutineScope