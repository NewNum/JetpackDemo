package com.app.baselib.utils

import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import java.util.*

/**
 * @author huxh
 * @date 2019/3/23.
 */
class RecyclerViewHolder private constructor(convertView: View) :
    RecyclerView.ViewHolder(convertView), LayoutContainer {
    private val mViews: SparseArray<View> by lazy { SparseArray<View>() }
    private val objects: HashMap<String, Any> by lazy { HashMap<String, Any>() }

    override val containerView: View?
        get() = itemView

    fun <T> getObject(key: String): T? {
        return if (objects[key] == null) {
            null
        } else {
            objects[key] as? T
        }
    }

    fun addObject(key: String, `object`: Any) {
        objects[key] = `object`
    }

    /**
     * 通过viewId获取控件
     *
     * @param viewId
     * @return
     */
    fun <T : View> getView(viewId: Int): T? {
        var view: View? = mViews.get(viewId)
        if (view == null) {
            view = itemView.findViewById(viewId)
            mViews.put(viewId, view)
        }
        return view as? T
    }

    /**
     * 通过viewId获取控件
     *
     * @return
     */
    fun <T : View> getView(viewId: Int, clazz: Class<T>): T? {
        var view: View? = mViews.get(viewId)
        if (view == null) {
            view = itemView.findViewById(viewId)
            mViews.put(viewId, view)
        }
        return view as? T
    }

    /**
     * 通过viewId获取控件
     *
     * @param viewId
     * @return
     */
    fun <T : View> findViewById(viewId: Int): T? {
        return getView(viewId)
    }

    /**
     * 通过viewId获取控件
     *
     * @return
     */
    fun <T : View> findViewById(viewId: Int, clazz: Class<T>): T? {
        return getView(viewId, clazz)
    }

    /**
     * 关于事件的
     */
    fun setOnClickListener(
        viewId: Int,
        listener: View.OnClickListener
    ): RecyclerViewHolder {
        val view = getView<View>(viewId)
        view?.setOnClickListener(listener)
        return this
    }

    interface OnItemClickListener<T> {
        fun onItemClick(data: T, view: View, position: Int)
    }

    companion object {

        fun createViewHolder(parent: ViewGroup, layoutId: Int): RecyclerViewHolder {
            return createViewHolder(
                LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
            )
        }

        fun createViewHolder(
            view: View
        ): RecyclerViewHolder {
            return RecyclerViewHolder(view)
        }
    }

}
