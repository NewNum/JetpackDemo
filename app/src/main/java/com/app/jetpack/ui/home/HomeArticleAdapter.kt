package com.app.jetpack.ui.home

import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.app.baselib.utils.RecyclerViewBindingHolder
import com.app.baselib.utils.RecyclerViewHolder
import com.app.baselib.utils.getViewHolder
import com.app.jetpack.R
import com.app.jetpack.data.net.api.article.Article
import com.app.jetpack.databinding.RecyclerItemHomeArticleBinding

class HomeArticleAdapter() : PagedListAdapter<Article, RecyclerViewBindingHolder<RecyclerItemHomeArticleBinding>>(DIFF_ARTICLE) {

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


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewBindingHolder<RecyclerItemHomeArticleBinding> {
        return parent.getViewHolder(RecyclerItemHomeArticleBinding::inflate)
    }

    override fun onBindViewHolder(holder: RecyclerViewBindingHolder<RecyclerItemHomeArticleBinding>, position: Int) {
        holder.viewBinding.tvTitle.text = HtmlCompat.fromHtml(getItem(position)?.title?:"加载中",HtmlCompat.FROM_HTML_MODE_COMPACT)
    }
}