package com.ruialmeida.quarentilograms.features.newpost.fragment

import com.ruialmeida.quarentilograms.R
import com.ruialmeida.quarentilograms.databinding.FragmentNewpostBinding
import com.ruialmeida.quarentilograms.features.newpost.viewmodel.NewPostFragmentViewModel
import com.ruialmeida.quarentilograms.shared.fragment.BaseDataBindingFragment

class NewPostFragment : BaseDataBindingFragment<FragmentNewpostBinding, NewPostFragmentViewModel>(R.layout.fragment_newpost, NewPostFragmentViewModel::class) {
    override fun handleInteractions(binding: FragmentNewpostBinding, viewModel: NewPostFragmentViewModel) {

    }
}