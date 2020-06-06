package com.app.jetpack.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.fmt.github.base.viewmodel.BaseViewModel
import com.app.jetpack.article.ArticleRepository
import com.app.jetpack.article.Flag
import com.app.jetpack.article.HomeArticleDataFactory
import com.app.jetpack.article.dao.Article

class HomeArticleViewModel(private val articleRepository: ArticleRepository) : BaseViewModel() {

    private val _articles: LiveData<PagedList<Article>> =
        LivePagedListBuilder<Int, Article>(HomeArticleDataFactory(articleRepository), Flag.SIZE).build();


    fun getArticle() = _articles
}