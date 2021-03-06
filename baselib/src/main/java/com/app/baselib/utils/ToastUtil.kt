package com.app.baselib.utils

import android.widget.Toast
import androidx.annotation.StringRes
import com.app.baselib.AppContext

fun toast(msg: String) {
    shortToast(msg)

}

fun toast(@StringRes res: Int) {
    shortToast(res)
}

fun shortToast(msg: String) {
    toastCreate().run {
        setText(msg)
        duration = Toast.LENGTH_SHORT
        show()
    }
}

fun shortToast(@StringRes res: Int) {
    toastCreate().run {
        setText(res)
        duration = Toast.LENGTH_SHORT
        show()
    }
}

fun longToast(msg: String) {
    toastCreate().run {
        setText(msg)
        duration = Toast.LENGTH_LONG
        show()
    }
}

fun longToast(@StringRes res: Int) {
    toastCreate().run {
        setText(res)
        duration = Toast.LENGTH_LONG
        show()
    }
}

private fun toastCreate(): Toast {
    return Toast.makeText(AppContext,"",Toast.LENGTH_SHORT)
}