package com.app.jetpack.article

import androidx.paging.DataSource
import androidx.paging.PositionalDataSource
import com.app.jetpack.article.dao.Article
import org.koin.android.ext.android.inject

class HomeArticleDataSource(private val articleRepository: ArticleRepository): PositionalDataSource<Article>() {
    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Article>) {
        callback.onResult(articleRepository.getArticles(0))
    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Article>) {
       callback.onResult( articleRepository.getArticles(params.requestedStartPosition),0)
    }
}