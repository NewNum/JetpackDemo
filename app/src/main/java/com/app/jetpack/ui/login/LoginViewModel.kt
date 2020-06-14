package com.app.jetpack.ui.login

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import com.app.baselib.base.viewmodel.BaseViewModel
import com.app.jetpack.data.model.BaseData
import com.app.jetpack.data.net.UserServer

data class LoginViewModel(
    val username: ObservableField<String> = ObservableField(""),
    val password: ObservableField<String> = ObservableField("")
) : BaseViewModel() {
    fun login(): LiveData<BaseData> = emit {
        UserServer.login(username.get() ?: "", password.get() ?: "")
    }
}