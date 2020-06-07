package com.app.jetpack.data.net

import android.util.Log
import com.app.jetpack.AppContext
import com.app.jetpack.BuildConfig
import com.app.jetpack.article.net.ArticleApi
import com.app.jetpack.user.UserApi
import com.franmontiel.persistentcookiejar.PersistentCookieJar
import com.franmontiel.persistentcookiejar.cache.SetCookieCache
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


private const val BASE_URL = "https://www.wanandroid.com/"
private const val TIME_OUT = 60L
private const val TAG = "huxh"

val httpLoggingInterceptor = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
    override fun log(message: String) {
        Log.e(TAG, message)
    }
}).also {
    it.level = HttpLoggingInterceptor.Level.BODY
}

val okHttpClient = OkHttpClient.Builder()
    .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
    .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
    .readTimeout(TIME_OUT, TimeUnit.SECONDS).also {
        if (BuildConfig.DEBUG) {
            it.addInterceptor(httpLoggingInterceptor)
        }
    }
    .cookieJar(PersistentCookieJar(SetCookieCache(),SharedPrefsCookiePersistor(AppContext)))
    .build()

val retrofit: Retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .client(okHttpClient)
    .baseUrl(BASE_URL)
    .build()


object ArticleServer : ArticleApi by retrofit.create(ArticleApi::class.java)

object UserServer : UserApi by retrofit.create(UserApi::class.java)