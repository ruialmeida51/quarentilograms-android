package com.ruialmeida.quarentilograms.features.homepage.activity

import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.ruialmeida.lumbridgelibrary.activities.base.BaseStatefulActivity
import com.ruialmeida.quarentilograms.R
import com.ruialmeida.quarentilograms.databinding.ActivityHomepageBinding
import com.ruialmeida.quarentilograms.features.homepage.state.HomePageErrorState
import com.ruialmeida.quarentilograms.features.homepage.state.HomePageState
import com.ruialmeida.quarentilograms.features.homepage.viewmodel.HomePageViewModel
import reactivecircus.flowbinding.android.view.clicks

class HomePageActivity : BaseStatefulActivity<ActivityHomepageBinding, HomePageViewModel, HomePageState, HomePageErrorState>() {
    override fun setupContent() {

    }

    override fun setupObservables() {

    }

    override fun setupClickListeners() {
        viewModel.bindClick(
            binding.test1.clicks(),
            binding.test2.clicks()
        )
    }


    override fun handleUpdateScreenFromState(newState: HomePageState?) {

    }

    override fun handleUpdateScreenFromError(errorState: HomePageErrorState?) {
        when(errorState?.errorType) {
            HomePageErrorState.HomePageErrorTypes.FetchError -> {}
        }
    }

    override fun setupDataBinding(): ActivityHomepageBinding = DataBindingUtil.setContentView(this, R.layout.activity_homepage)
    override fun setupViewModel(): HomePageViewModel = ViewModelProvider.NewInstanceFactory().create(HomePageViewModel::class.java)
}