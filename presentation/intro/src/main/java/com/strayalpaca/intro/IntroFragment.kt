package com.strayalpaca.intro

import android.os.Bundle
import android.view.View
import androidx.core.net.toUri
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.strayalpaca.intro.databinding.IntroScreenBinding
import com.strayalpaca.presentation.ViewBindingFragment

class IntroFragment : ViewBindingFragment<IntroScreenBinding>(IntroScreenBinding::bind, R.layout.intro_screen) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnMoveToLogin.setOnClickListener {
            val request = NavDeepLinkRequest.Builder
                .fromUri(getString(com.strayalpaca.presentation.R.string.deep_link_login).toUri())
                .build()
            val navOption = NavOptions.Builder().setPopUpTo(0, inclusive = false).build()

            findNavController().popBackStack()
            findNavController().navigate(request, navOption)
        }
    }
}