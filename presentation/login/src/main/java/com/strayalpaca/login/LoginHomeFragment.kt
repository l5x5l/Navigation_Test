package com.strayalpaca.login

import android.os.Bundle
import android.view.View
import androidx.core.net.toUri
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.strayalpaca.login.databinding.LoginHomeScreenBinding
import com.strayalpaca.presentation.ViewBindingFragment

class LoginHomeFragment : ViewBindingFragment<LoginHomeScreenBinding>(LoginHomeScreenBinding::bind, R.layout.login_home_screen) {

    private val args : LoginHomeFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        checkNavArgs()
        initButton()
    }

    private fun checkNavArgs() {
        val loginSuccess = args.loginSuccess
        if (loginSuccess) {
            val request = NavDeepLinkRequest.Builder
                .fromUri(getString(com.strayalpaca.presentation.R.string.deep_link_home).toUri())
                .build()

            findNavController().popBackStack()
            findNavController().navigate(request)
        }
    }

    private fun initButton() {
        binding.btnLogin.setOnClickListener {
            findNavController().navigate(R.id.action_loginHomeFragment_to_signUpStep1Fragment)
        }
    }
}