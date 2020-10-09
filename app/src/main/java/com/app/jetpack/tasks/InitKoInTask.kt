package com.app.jetpack.tasks

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
