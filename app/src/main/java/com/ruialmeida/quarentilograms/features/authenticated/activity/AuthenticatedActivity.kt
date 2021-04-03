package com.ruialmeida.quarentilograms.features.authenticated.activity

import android.os.Handler
import android.os.Looper
import androidx.navigation.ui.setupWithNavController
import com.ruialmeida.quarentilograms.R
import com.ruialmeida.quarentilograms.databinding.ActivityAuthenticatedBinding
import com.ruialmeida.quarentilograms.features.authenticated.viewmodel.AuthenticatedActivityViewModel
import com.ruialmeida.quarentilograms.features.feed.fragment.FeedFragment
import com.ruialmeida.quarentilograms.shared.activity.BaseNavigationDataBindingActivity
import com.ruialmeida.quarentilograms.shared.extensions.platform.showToast

class AuthenticatedActivity :
    BaseNavigationDataBindingActivity<ActivityAuthenticatedBinding, AuthenticatedActivityViewModel>(
        R.layout.activity_authenticated,
        R.id.activity_authenticated_navigation_host_fragment,
        AuthenticatedActivityViewModel::class
    ) {

    companion object {
        private const val TAG = "AuthenticatedActivity"

        private const val BACK_PRESSED_DELAY = 2000L
    }

    private val handler = Handler(Looper.myLooper() ?: Looper.getMainLooper())

    private var doubleBackToExitPressedOnce = false

    override fun handleInteractions(
        binding: ActivityAuthenticatedBinding,
        viewModel: AuthenticatedActivityViewModel,
    ) {
        binding.activityAuthenticatedBottomNavigation.setupWithNavController(getNavHostFragment().navController)
    }

    override fun onBackPressed() {
        if (getNavHostFragment().childFragmentManager.fragments.first() !is FeedFragment) {
            super.onBackPressed()
        } else {
            if (doubleBackToExitPressedOnce) { super.onBackPressed(); return }
            doubleBackToExitPressedOnce = true
            showToast(this, R.string.back_button_pressed_message)
            handler.postDelayed({ doubleBackToExitPressedOnce = false }, BACK_PRESSED_DELAY)
        }
    }

}