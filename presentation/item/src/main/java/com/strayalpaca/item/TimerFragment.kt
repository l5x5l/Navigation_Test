package com.strayalpaca.item

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.strayalpaca.item.databinding.TimerScreenBinding
import com.strayalpaca.presentation.ViewBindingFragment

class TimerFragment : ViewBindingFragment<TimerScreenBinding>(TimerScreenBinding::bind, R.layout.timer_screen) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initButton()
    }

    private fun initButton() {
        binding.btnBack.root.setOnClickListener{
            findNavController().popBackStack()
        }
    }
}