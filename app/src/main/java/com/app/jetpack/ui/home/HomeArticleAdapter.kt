package com.app.jetpack.ui.home

import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.app.jetpack.R
import com.app.jetpack.article.dao.Article
import com.app.jetpack.utils.RecyclerViewHolder
import kotlinx.android.synthetic.main.recycler_item_home_article.*

class HomeArticleAdapter() : PagedListAdapter<Article, RecyclerViewHolder>(DIFF_ARTICLE) {

    companion object {
        //  比较的行为
        private val DIFF_ARTICLE: DiffUtil.ItemCallback<Article> =
            object : DiffUtil.ItemCallback<Article>() {
                // 一般是比较 唯一性的内容， ID
                override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
                    return oldItem.id == newItem.id
                }

                // 对象本身的比较
                override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
                    return oldItem.equals(newItem)
                }
            }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        return RecyclerViewHolder.Companion.createViewHolder(parent, R.layout.recycler_item_home_article)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.tvTitle.text = HtmlCompat.fromHtml(getItem(position)?.title?:"加载中",HtmlCompat.FROM_HTML_MODE_COMPACT)
    }
}