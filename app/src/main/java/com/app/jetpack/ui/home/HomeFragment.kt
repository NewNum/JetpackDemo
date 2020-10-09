package com.app.jetpack.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.jetpack.R
import com.app.baselib.base.fragment.BaseViewModelFragment
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseViewModelFragment() {

    override val viewModel: HomeArticleViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvHome.layoutManager = LinearLayoutManager(requireContext())
        rvHome.adapter = HomeArticleAdapter()
        viewModel.pagedList.observe(viewLifecycleOwner, Observer {
            val adapter = rvHome.adapter
            if (adapter is HomeArticleAdapter) {
                adapter.submitList(it)
            }
        })

    }

    override fun layoutId(): Int {
        return R.layout.fragment_home
    }

}
