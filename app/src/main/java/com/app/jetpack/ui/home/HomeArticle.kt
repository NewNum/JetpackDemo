package com.app.jetpack.ui.home

import com.app.jetpack.article.Article
import com.app.jetpack.data.model.BaseData

data class HomeArticle(val data: Data) : BaseData()
data class Data(
    val offset: Int,
    val over: Boolean,
    val pageCount: Int,
    val size: Int,
    val total: Int,
    val curPage: Int,
    val datas: List<Article>
)