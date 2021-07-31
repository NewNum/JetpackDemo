package com.app.jetpack.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewbinding.ViewBinding
import com.app.baselib.base.fragment.BaseViewBindingViewModelFragment
import com.app.jetpack.R
import com.app.baselib.base.fragment.BaseViewModelFragment
import com.app.jetpack.databinding.FragmentHomeBinding

class HomeFragment : BaseViewBindingViewModelFragment<FragmentHomeBinding>() {

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

    override fun initViewBinding(): (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding {
        return FragmentHomeBinding::inflate
    }

}
