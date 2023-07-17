package com.strayalpaca.navigation_test

import android.os.Bundle
import com.strayalpaca.navigation_test.databinding.ActivityMainBinding
import com.strayalpaca.presentation.ViewBindingActivity

class MainActivity : ViewBindingActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}