package com.app.baselib.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.viewbinding.ViewBinding

abstract class BaseViewBindingViewModelFragment<DB : ViewBinding> : BaseViewModelFragment() {

    lateinit var db: DB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (!::db.isInitialized) {
            db = initViewBinding().invoke(inflater, container, false)
        }
        return db.root
    }

    abstract fun initViewBinding(): ((
        LayoutInflater,
        ViewGroup?,
        Boolean
    ) -> DB)
}