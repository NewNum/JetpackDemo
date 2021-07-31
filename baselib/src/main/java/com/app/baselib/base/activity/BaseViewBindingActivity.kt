package com.app.baselib.base.activity

import android.view.LayoutInflater
import androidx.annotation.LayoutRes
import androidx.viewbinding.ViewBinding

abstract class BaseViewBindingActivity<DB : ViewBinding> : BaseActivity() {

    lateinit var db: DB
    override fun setContentLayout() {
        db = initViewBinding().invoke(layoutInflater)
        setContentView(db.root)
        onViewCreate()
        initData()
    }


    abstract fun initViewBinding(): ((
        LayoutInflater,
    ) -> DB)

    abstract override fun onViewCreate()

    @LayoutRes
    abstract override fun layoutId(): Int
}
