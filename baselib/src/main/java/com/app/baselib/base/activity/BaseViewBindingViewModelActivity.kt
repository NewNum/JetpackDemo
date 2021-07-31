package com.app.baselib.base.activity

import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.viewbinding.ViewBinding

/**
 * 封装带有协程基类(DataBinding + ViewModel),使用代理类完成
 *
 */
abstract class BaseViewBindingViewModelActivity<DB : ViewBinding> : BaseViewModelActivity() {

    lateinit var db: DB

    override fun setContentLayout() {
        db = initViewBinding().invoke(layoutInflater)
        setContentView(db.root)
        initViewModelAction()
        onViewCreate()
        initData()
    }

    abstract fun initViewBinding(): ((
        LayoutInflater,
    ) -> DB)

}