package com.app.jetpack.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.jetpack.R
import com.app.baselib.base.fragment.BaseDataBindingViewModelFragment
import com.app.jetpack.databinding.FragmentHomeBinding

class HomeFragment : BaseDataBindingViewModelFragment<FragmentHomeBinding>() {

    override val viewModel: HomeArticleViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        db.rvHome.layoutManager = LinearLayoutManager(requireContext())
        db.rvHome.adapter = HomeArticleAdapter()
        viewModel.pagedList.observe(viewLifecycleOwner, Observer {
            val adapter = db.rvHome.adapter
            if (adapter is HomeArticleAdapter) {
                adapter.submitList(it)
            }
        })

    }

    override fun layoutId(): Int {
        return R.layout.fragment_home
    }

}
