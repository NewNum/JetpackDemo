package com.app.jetpack.base.activity

import android.util.Log
import androidx.lifecycle.Observer
import com.app.jetpack.base.viewmodel.BaseViewModel
import com.app.jetpack.base.viewmodel.ErrorState
import com.app.jetpack.base.viewmodel.LoadState
import com.app.jetpack.base.viewmodel.SuccessState
import com.app.jetpack.utils.longToast
import com.app.jetpack.utils.toast

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
                            Log.d(com.app.jetpack.TAG, "initViewModelAction: $this")
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