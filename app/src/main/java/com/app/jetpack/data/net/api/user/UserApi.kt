package com.app.jetpack.data.net.api.user

import com.app.jetpack.data.model.BaseData
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UserApi {

    @FormUrlEncoded
    @POST("user/login")
    suspend fun login(@Field("username") username: String,@Field("password")  password: String):BaseData
}