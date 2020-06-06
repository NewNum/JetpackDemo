package com.app.jetpack.tasks

import com.fmt.launch.starter.task.Task
import com.app.jetpack.article.ArticleRepository
import com.app.jetpack.article.net.ArticleApi
import com.app.jetpack.data.dao.articleDao
import com.app.jetpack.data.net.ArticleServer
import com.app.jetpack.ui.home.HomeArticleViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
/*

class InitKoInTask : Task() {
    override fun run() {
        startKoin {
            modules(appModules)
        }
    }
}

val viewModelModule = module {
    viewModel { HomeArticleViewModel(get()) }
//    viewModel { ReceivedEventViewModel(get()) }
//    viewModel { ReposViewModel(get()) }
    viewModel { ArticleViewModel(get()) }
}

val reposModule = module {
    //factory 每次注入时都重新创建一个新的对象
//    factory { ReposRepository(get()) }
    factory { ArticleRepository(get(), get()) }
}

val remoteModule = module {
    //single 单列注入
//    single<ReposApi> { ReposService }

    single<ArticleApi> { ArticleServer }
}

val localModule = module {
    single { articleDao }
}


val appModules = listOf(viewModelModule, reposModule, remoteModule, localModule)*/
