package com.ruialmeida.quarentilograms.features.search.fragment

import com.ruialmeida.quarentilograms.R
import com.ruialmeida.quarentilograms.databinding.FragmentSearchBinding
import com.ruialmeida.quarentilograms.features.search.viewmodel.SearchFragmentViewModel
import com.ruialmeida.quarentilograms.shared.fragment.BaseDataBindingFragment

class SearchFragment : BaseDataBindingFragment<FragmentSearchBinding, SearchFragmentViewModel>(R.layout.fragment_search, SearchFragmentViewModel::class) {
    override fun handleInteractions(binding: FragmentSearchBinding, viewModel: SearchFragmentViewModel) {

    }
}