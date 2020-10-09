package com.app.jetpack.article

import com.app.jetpack.article.dao.Article
import com.app.jetpack.article.net.ArticleApi

class ArticleRepository(private val articleApi: ArticleApi) {
    fun getArticles(page: Int): List<Article> {
//        val homeArticle = articleApi.homeArticle(page)
//        return if (homeArticle.errorCode == 0) {
//            homeArticle.data.datas
//        } else {
//            emptyList()
//        }
        return emptyList()

    }
}