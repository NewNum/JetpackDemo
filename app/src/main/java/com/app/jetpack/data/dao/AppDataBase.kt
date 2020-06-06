package com.app.jetpack.data.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.jetpack.article.dao.ArticleDao
import com.app.jetpack.article.dao.Article

@Database(entities = [Article::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {

    abstract fun getArticleDao(): ArticleDao

}