package com.ruialmeida.quarentilograms.features.feed.fragment

import com.ruialmeida.quarentilograms.R
import com.ruialmeida.quarentilograms.databinding.FragmentFeedBinding
import com.ruialmeida.quarentilograms.features.feed.viewmodel.FeedFragmentViewModel
import com.ruialmeida.quarentilograms.shared.fragment.BaseDataBindingFragment

class FeedFragment : BaseDataBindingFragment<FragmentFeedBinding, FeedFragmentViewModel>(R.layout.fragment_feed, FeedFragmentViewModel::class) {
    override fun handleInteractions(binding: FragmentFeedBinding, viewModel: FeedFragmentViewModel) {
    }
}