package com.app.baselib.base.fragment

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.app.baselib.TAG
import com.app.baselib.base.viewmodel.BaseViewModel
import com.app.baselib.base.viewmodel.ErrorState
import com.app.baselib.base.viewmodel.LoadState
import com.app.baselib.base.viewmodel.SuccessState
import com.app.baselib.utils.longToast
import com.app.baselib.utils.toast

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