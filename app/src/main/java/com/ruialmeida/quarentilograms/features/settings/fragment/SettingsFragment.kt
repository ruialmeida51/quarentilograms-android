package com.ruialmeida.quarentilograms.features.settings.fragment

import androidx.fragment.app.Fragment
import com.ruialmeida.quarentilograms.R
import com.ruialmeida.quarentilograms.databinding.FragmentSettingsBinding
import com.ruialmeida.quarentilograms.features.settings.viewmodel.SettingsFragmentViewModel
import com.ruialmeida.quarentilograms.shared.fragment.BaseDataBindingFragment

class SettingsFragment : BaseDataBindingFragment<FragmentSettingsBinding, SettingsFragmentViewModel>(R.layout.fragment_settings, SettingsFragmentViewModel::class) {
    override fun handleInteractions(binding: FragmentSettingsBinding, viewModel: SettingsFragmentViewModel) {

    }
}