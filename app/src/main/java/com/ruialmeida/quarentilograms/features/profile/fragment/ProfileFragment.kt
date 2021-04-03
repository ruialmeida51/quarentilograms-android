package com.ruialmeida.quarentilograms.features.profile.fragment

import com.ruialmeida.quarentilograms.R
import com.ruialmeida.quarentilograms.databinding.FragmentProfileBinding
import com.ruialmeida.quarentilograms.features.profile.viewmodel.ProfileFragmentViewModel
import com.ruialmeida.quarentilograms.shared.fragment.BaseDataBindingFragment

class ProfileFragment : BaseDataBindingFragment<FragmentProfileBinding, ProfileFragmentViewModel>(R.layout.fragment_profile, ProfileFragmentViewModel::class) {
    override fun handleInteractions(binding: FragmentProfileBinding, viewModel: ProfileFragmentViewModel) {

    }
}