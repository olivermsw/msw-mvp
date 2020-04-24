package com.olimsw.android.demo.mvp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.olimsw.fragment.navigator.ShowHideFragmentNavigator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navController = findNavController(R.id.nav_host_fragment)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)!!
        //设置ShowHideFragmentNavigator
        navController.navigatorProvider.addNavigator(
            ShowHideFragmentNavigator(
                this,
                navHostFragment.childFragmentManager,
                R.id.nav_host_fragment,
                R.anim.slide_in_right,
                R.anim.slide_out_left,
                R.anim.slide_in_left,
                R.anim.slide_out_right
            )
        )
        navController.setGraph(R.navigation.nav) //必须使用代码显示设置
    }


}