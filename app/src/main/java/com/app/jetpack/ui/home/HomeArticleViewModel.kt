package com.app.jetpack.ui.home

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import androidx.paging.PositionalDataSource
import com.app.jetpack.article.dao.Article
import com.app.jetpack.article.net.ArticleApi
import com.app.jetpack.base.viewmodel.BaseLPagingViewModel
import com.app.jetpack.base.viewmodel.BaseViewModel
import com.app.jetpack.config.Configs
import com.app.jetpack.data.net.ArticleServer

class HomeArticleViewModel() : BaseLPagingViewModel<Article>() {

    private val articleApi: ArticleApi by lazy {
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