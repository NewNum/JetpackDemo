package com.app.jetpack.ui.login

import android.view.View
import androidx.activity.viewModels
import androidx.databinding.Observable
import androidx.lifecycle.Observer
import com.app.jetpack.R
import com.app.baselib.base.activity.BaseDataBindingViewModelActivity
import com.app.jetpack.config.Settings
import com.app.jetpack.databinding.ActivityLoginBinding
import com.app.jetpack.ext.otherwise
import com.app.jetpack.ext.yes
import java.util.*

class LoginActivity : BaseDataBindingViewModelActivity<ActivityLoginBinding>() {

    override fun onViewCreate() {
        db.loginViewModel = viewModel
        setSupportActionBar(db.tbLogin)
        db.btnLogin.setOnClickListener {
            login()
        }
        val userName = Settings.Account.userName
        userName.isNotEmpty().yes {
            viewModel.username.set(userName)
        }
        val callback = object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                db.tvWarning.text = ""
            }
        }
        viewModel.username.addOnPropertyChangedCallback(callback)
        viewModel.password.addOnPropertyChangedCallback(callback)
    }

    private fun login() {
        val username = viewModel.username.get().toString()
        val password = viewModel.password.get().toString()
        username.isEmpty().yes {
            db.tilUserName.error = getString(R.string.username_not_null)
            db.tilUserName.isErrorEnabled = true
        }.otherwise {
            db.tilUserName.isErrorEnabled = false
            password.isEmpty().yes {
                db.tilPassword.error = getString(R.string.password_not_null)
                db.tilPassword.isErrorEnabled = true
            }.otherwise {
                db.tilPassword.isErrorEnabled = false
                toLogin()
            }
        }
    }

    override fun showLoading() {
        db.btnLogin.visibility = View.GONE
        db.pbLogin.visibility = View.VISIBLE
    }

    override fun dismissLoading() {
        db.btnLogin.visibility = View.VISIBLE
        db.pbLogin.visibility = View.GONE
    }

    private fun toLogin() {
        viewModel.login().observe(this, Observer {
            (it.errorCode == 0).yes {
                Settings.Account.userName = viewModel.username.get() ?: ""
                Settings.Account.password = viewModel.password.get() ?: ""
                finish()
            }.otherwise {
                db.tvWarning.text = it.errorMsg
            }

        })
    }

    override fun layoutId(): Int {
        return R.layout.activity_login
    }

    override val viewModel: LoginViewModel by viewModels()

}