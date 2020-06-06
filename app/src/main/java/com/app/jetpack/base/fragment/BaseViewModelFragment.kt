package com.app.jetpack.base.fragment

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.app.jetpack.TAG
import com.app.jetpack.base.viewmodel.BaseViewModel
import com.app.jetpack.base.viewmodel.ErrorState
import com.app.jetpack.base.viewmodel.LoadState
import com.app.jetpack.base.viewmodel.SuccessState
import com.app.jetpack.utils.longToast
import com.app.jetpack.utils.toast

abstract class BaseViewModelFragment : BaseFragment() {

    protected abstract val viewModel: BaseViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModelAction()
    }


    private fun initViewModelAction() {
        viewModel.let { baseViewModel ->
            baseViewModel.mStateLiveData.observe(this, Observer { stateActionState ->
                when (stateActionState) {
                    LoadState -> showLoading()
                    SuccessState -> dismissLoading()
                    is ErrorState -> {
                        dismissLoading()
                        stateActionState.message?.apply {
                            Log.d(TAG, "initViewModelAction: $this")
                            longToast(this)
                            handleError()
                        }
                    }
                }
            })
        }
    }

    open fun handleError() {}

}