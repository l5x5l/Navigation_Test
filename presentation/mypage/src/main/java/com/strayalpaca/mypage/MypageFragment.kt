package com.strayalpaca.mypage

import android.os.Bundle
import android.view.View
import androidx.core.net.toUri
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.NavOptions
import com.strayalpaca.mypage.databinding.MypageScreenBinding
import com.strayalpaca.presentation.ViewBindingFragment
import com.strayalpaca.presentation.util.ErrorDetector
import com.strayalpaca.presentation.util.getParentNavController

class MypageFragment : ViewBindingFragment<MypageScreenBinding>(MypageScreenBinding::bind, R.layout.mypage_screen) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initButton()
    }

    private fun initButton() {
        binding.btnLogout.setOnClickListener {
            // backQueue 의 0번째 NavBackStackEntry 는 navGraph 자체에 대한 정보가 들어가 있었다.
            val start = getParentNavController()?.backQueue?.get(1)?.destination?.id

            start?.let{
                val request = NavDeepLinkRequest.Builder
                    .fromUri(getString(com.strayalpaca.presentation.R.string.deep_link_intro).toUri())
                    .build()

                val navOptions = NavOptions.Builder().setPopUpTo(it, true).build()

                getParentNavController()?.popBackStack()
                getParentNavController()?.navigate(request, navOptions)
            }

        }

        binding.btnTokenError.setOnClickListener {
            ErrorDetector.setTokenExpired()
        }
    }
}