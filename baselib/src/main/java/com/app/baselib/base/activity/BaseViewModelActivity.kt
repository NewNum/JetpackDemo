package com.app.baselib.base.activity

import android.util.Log
import androidx.lifecycle.Observer
import com.app.baselib.base.viewmodel.BaseViewModel
import com.app.baselib.base.viewmodel.ErrorState
import com.app.baselib.base.viewmodel.LoadState
import com.app.baselib.base.viewmodel.SuccessState
import com.app.baselib.utils.longToast

abstract class BaseViewModelActivity : BaseActivity() {

    protected abstract val viewModel: BaseViewModel

    protected fun initViewModelAction() {
        viewModel.let { baseViewModel ->
            baseViewModel.mStateLiveData.observe(this, Observer { stateActionState ->
                when (stateActionState) {
                    LoadState -> showLoading()
                    SuccessState -> dismissLoading()
                    is ErrorState -> {
                        dismissLoading()
                        stateActionState.message?.apply {
                            Log.d(com.app.baselib.TAG, "initViewModelAction: $this")
                            longToast(this)
                            handleError()
                        }
                    }
                }
            })
        }
    }

    override fun setContentLayout() {
        setContentView(layoutId())
        initViewModelAction()
        onViewCreate()
        initData()
    }

    open fun handleError() {}


}