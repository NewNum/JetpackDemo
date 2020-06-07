package com.app.jetpack.base.activity

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentLayout()
    }

    open fun setContentLayout() {
        setContentView(layoutId())
        onViewCreate()
        initData()
    }

    open fun initData() {}

    abstract fun onViewCreate()

    @LayoutRes
    abstract fun layoutId(): Int

    open fun showLoading() {}

    open fun dismissLoading() {}

    fun startActivity(cls: Class<*>) {
        startActivity(Intent(this, cls))
    }

}
