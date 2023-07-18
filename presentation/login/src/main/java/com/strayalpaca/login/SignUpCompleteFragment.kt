package com.strayalpaca.login

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.strayalpaca.login.databinding.SignupCompleteBinding
import com.strayalpaca.presentation.ViewBindingFragment
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SignUpCompleteFragment : ViewBindingFragment<SignupCompleteBinding>(SignupCompleteBinding::bind, R.layout.signup_complete) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            delay(1000L)

            val action = SignUpCompleteFragmentDirections.actionSignUpCompleteFragmentToLoginHomeFragment(loginSuccess = true)
            findNavController().navigate(action)
        }
    }
}