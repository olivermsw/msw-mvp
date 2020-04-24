package com.olimsw.android.demo.mvp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.olimsw.android.demo.mvp.R
import com.olimsw.android.demo.mvp.contract.Blank1Contract
import com.olimsw.android.mvp.MSWFragment
import com.olimsw.android.mvp.annotation.InjectPresenter

@InjectPresenter(Blank1Contract.Presenter::class)
class Blank1Fragment : MSWFragment<Blank1Contract.Presenter>(), Blank1Contract.View {
    val a: String by lazy { "" }
    lateinit var tv: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        val presenter1 = presenter
//        Log.w("msw", presenter.hashCode().toString())
//        val n = measureTimeMillis {
//            presenter.getData()
//        }
//        Log.w("msw", n.toString())

        return inflater.inflate(R.layout.fragment_blank1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button).setOnClickListener {
            presenter.getData()
        }
        tv = view.findViewById(R.id.tv)
    }

    override fun showData(data: String) {
        tv.text = data
    }


}