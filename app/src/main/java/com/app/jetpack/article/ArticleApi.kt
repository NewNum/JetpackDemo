package com.app.jetpack.article

import com.app.jetpack.ui.home.HomeArticle
import retrofit2.http.GET
import retrofit2.http.Path

interface ArticleApi {

    @GET("article/list/{page}/json")
    suspend fun homeArticle(@Path("page") page: Int): HomeArticle
}