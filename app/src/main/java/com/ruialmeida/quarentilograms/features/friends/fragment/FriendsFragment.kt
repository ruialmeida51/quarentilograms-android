package com.ruialmeida.quarentilograms.features.friends.fragment

import com.ruialmeida.quarentilograms.R
import com.ruialmeida.quarentilograms.databinding.FragmentFriendsBinding
import com.ruialmeida.quarentilograms.features.friends.viewmodel.FriendsFragmentViewModel
import com.ruialmeida.quarentilograms.shared.fragment.BaseDataBindingFragment

class FriendsFragment : BaseDataBindingFragment<FragmentFriendsBinding, FriendsFragmentViewModel>(R.layout.fragment_friends, FriendsFragmentViewModel::class) {
    override fun handleInteractions(binding: FragmentFriendsBinding, viewModel: FriendsFragmentViewModel) {

    }
}