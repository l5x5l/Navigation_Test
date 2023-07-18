package com.strayalpaca.splash

import android.os.Bundle
import android.view.View
import androidx.core.net.toUri
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.strayalpaca.presentation.ViewBindingFragment
import com.strayalpaca.splash.databinding.StartScreenBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class StartFragment : ViewBindingFragment<StartScreenBinding>(StartScreenBinding::bind, R.layout.start_screen) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        goToIntroAfter1Sec()
    }

    private fun goToIntroAfter1Sec() {
        lifecycleScope.launch {
            delay(1000L)

            val request = NavDeepLinkRequest.Builder
                .fromUri(getString(com.strayalpaca.presentation.R.string.deep_link_intro).toUri())
                .build()
            val navOptions = NavOptions.Builder().setPopUpTo(0, true).build()

            findNavController().popBackStack()
            findNavController().navigate(request, navOptions)
        }
    }
}