package com.olimsw.android.demo.mvp.contract

import com.olimsw.android.mvp.MSWPresenter
import com.olimsw.android.mvp.MSWView
import com.olimsw.android.mvp.coroutines.lifeScope
import kotlinx.coroutines.launch
import rxhttp.toStr
import rxhttp.wrapper.param.RxHttp

interface Blank1Contract {
    interface View : MSWView {
        fun showData(data: String)
    }

    class Presenter : MSWPresenter<View>() {
        fun getData() {
            lifeScope.launch {
                val baidu = RxHttp.get("http://www.baidu.com")
                    .toStr()
                    .await()
                view?.showData(baidu)
            }

        }
    }
}