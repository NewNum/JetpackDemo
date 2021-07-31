package com.app.baselib.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

/**
 * @author huxh
 * @date 2019/3/23.
 */
class RecyclerViewBindingHolder<D : ViewBinding>(val viewBinding: D) :
    RecyclerView.ViewHolder(viewBinding.root)


fun <D : ViewBinding> ViewGroup.getViewHolder(
    method: (LayoutInflater, ViewGroup, Boolean) -> D
): RecyclerViewBindingHolder<D> {
    return RecyclerViewBindingHolder<D>(method.invoke(LayoutInflater.from(context), this, false))
}