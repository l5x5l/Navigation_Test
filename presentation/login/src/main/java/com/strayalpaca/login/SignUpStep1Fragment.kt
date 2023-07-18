package com.strayalpaca.login

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.strayalpaca.login.databinding.SignupStep1ScreenBinding
import com.strayalpaca.presentation.ViewBindingFragment

class SignUpStep1Fragment : ViewBindingFragment<SignupStep1ScreenBinding>(SignupStep1ScreenBinding::bind, R.layout.signup_step1_screen) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initButton()
    }

    private fun initButton() {
        binding.btnLogin.setOnClickListener {
            findNavController().navigate(R.id.action_signUpStep1Fragment_to_signUpStep2Fragment)
        }

        binding.btnBack.root.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}