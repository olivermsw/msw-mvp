package com.olimsw.android.mvp

import androidx.lifecycle.LifecycleOwner

open class MSWPresenter<V> {
    var view: V? = null
    var lifecycleOwner: LifecycleOwner? = null
    fun attach(iView: Any) {
        @Suppress("UNCHECKED_CAST")
        this.view = iView as V
        lifecycleOwner = iView as LifecycleOwner
    }

    fun onAttached() {

    }

    fun onDetached() {
        this.view = null
    }
}
