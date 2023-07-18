package com.strayalpaca.login

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.strayalpaca.login.databinding.SignupStep2ScreenBinding
import com.strayalpaca.presentation.ViewBindingFragment

class SignUpStep2Fragment : ViewBindingFragment<SignupStep2ScreenBinding>(SignupStep2ScreenBinding::bind, R.layout.signup_step2_screen) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initButton()
    }

    private fun initButton() {
        binding.btnLogin.setOnClickListener {
            findNavController().navigate(R.id.action_signUpStep2Fragment_to_signUpCompleteFragment)
        }

        binding.btnBack.root.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}