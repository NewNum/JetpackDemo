package com.app.jetpack.article

import androidx.paging.DataSource
import com.app.jetpack.article.dao.Article

class HomeArticleDataFactory(private val articleRepository: ArticleRepository) : DataSource.Factory<Int, Article>() {
    override fun create(): DataSource<Int, Article> {
        return HomeArticleDataSource(articleRepository)
    }
}