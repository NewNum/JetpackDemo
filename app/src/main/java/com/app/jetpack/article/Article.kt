package com.app.jetpack.article

data class Article(
    val id: Int,
    val title: String,
    val link: String
) {

    var apkLink: String? = null
    var audit = 0
    var author: String? = null
    var canEdit = false
    var chapterId = 0
    var chapterName: String? = null
    var collect = false
    var courseId = 0
    var desc: String? = null
    var descMd: String? = null
    var envelopePic: String? = null
    var fresh = false
    var niceDate: String? = null
    var niceShareDate: String? = null
    var origin: String? = null
    var prefix: String? = null
    var projectLink: String? = null
    var publishTime: Long = 0
    var selfVisible = 0
    var shareDate: Long = 0
    var shareUser: String? = null
    var superChapterId = 0
    var superChapterName: String? = null
//    var tags: MutableList<String> = mutableListOf<String>()
    var type = 0
    var userId = 0
    var visible = 0
    var zan = 0
}