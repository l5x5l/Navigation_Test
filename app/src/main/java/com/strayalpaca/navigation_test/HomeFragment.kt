package com.strayalpaca.navigation_test

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.strayalpaca.navigation_test.databinding.FragmentHomeBinding
import com.strayalpaca.presentation.ViewBindingFragment

class HomeFragment : ViewBindingFragment<FragmentHomeBinding>(FragmentHomeBinding::bind, R.layout.fragment_home) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navHostFragment = childFragmentManager.findFragmentById(R.id.nav_host_fragment_container_home) as NavHostFragment
        val navController = navHostFragment.navController

        binding.bottomHome.setupWithNavController(navController)
    }
}