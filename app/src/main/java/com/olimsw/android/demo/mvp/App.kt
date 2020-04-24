package com.olimsw.android.demo.mvp

import android.app.Application
import rxhttp.wrapper.param.RxHttp

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        RxHttp.setDebug(BuildConfig.DEBUG)
    }
}