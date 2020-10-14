package com.app.jetpack.ui.home

import com.app.jetpack.data.net.api.article.Article
import com.app.baselib.base.viewmodel.BaseLPagingViewModel
import com.app.jetpack.data.net.ArticleServer

class HomeArticleViewModel : BaseLPagingViewModel<Article>() {

    private val articleApi by lazy {
        ArticleServer
    }

    override suspend fun getDataList(page: Int): List<Article> {
        val homeArticle = articleApi.homeArticle(page)
        return if (homeArticle.errorCode == 0) {
            homeArticle.data.datas
        } else {
            emptyList<Article>()
        }
    }
}