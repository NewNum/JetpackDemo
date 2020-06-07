package com.app.jetpack.config

import com.app.jetpack.data.storage.Preference
import com.app.jetpack.utils.Constant


object Settings {

    object Account {
        var userName by Preference(Constant.USER_NAME, "")
        var password by Preference(Constant.USER_PASSWORD, "")
    }
}