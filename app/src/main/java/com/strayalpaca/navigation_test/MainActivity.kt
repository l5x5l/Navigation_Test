package com.strayalpaca.navigation_test

import android.os.Bundle
import androidx.core.net.toUri
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import com.strayalpaca.navigation_test.databinding.ActivityMainBinding
import com.strayalpaca.presentation.ViewBindingActivity
import com.strayalpaca.presentation.util.ErrorDetector
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : ViewBindingActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setUpObserver()
    }

    private fun setUpObserver() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                ErrorDetector.tokenExpired.collectLatest {
                    if (it) moveToIntro()
                }
            }
        }
    }

    private fun moveToIntro() {
        val navController = findNavController(binding.navHostFragmentContainer.id)
        val firstOfRoot = navController.backQueue[1].destination.id

        val request = NavDeepLinkRequest.Builder
            .fromUri(getString(com.strayalpaca.presentation.R.string.deep_link_intro).toUri())
            .build()
        val navOptions = NavOptions.Builder().setPopUpTo(firstOfRoot, true).build()
        navController.navigate(request, navOptions)
    }
}