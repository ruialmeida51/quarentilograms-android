package com.ruialmeida.quarentilograms.features.dms.fragment

import com.ruialmeida.quarentilograms.R
import com.ruialmeida.quarentilograms.databinding.FragmentDmsBinding
import com.ruialmeida.quarentilograms.features.dms.viewmodel.DmsFragmentViewModel
import com.ruialmeida.quarentilograms.shared.fragment.BaseDataBindingFragment

class DmsFragment : BaseDataBindingFragment<FragmentDmsBinding, DmsFragmentViewModel>(R.layout.fragment_dms, DmsFragmentViewModel::class) {
    override fun handleInteractions(binding: FragmentDmsBinding, viewModel: DmsFragmentViewModel) {
    }
}