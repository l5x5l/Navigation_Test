package com.strayalpaca.item

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.strayalpaca.item.databinding.ItemDetailScreenBinding
import com.strayalpaca.presentation.ViewBindingFragment

class ItemDetailFragment : ViewBindingFragment<ItemDetailScreenBinding>(ItemDetailScreenBinding::bind, R.layout.item_detail_screen) {

    private val args : ItemDetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val item = args.item
        println(item)

        initButton()
    }

    private fun initButton() {
        binding.btnBack.root.setOnClickListener{
            findNavController().popBackStack()
        }

        binding.btnMoveToTimer.setOnClickListener {
            findNavController().navigate(R.id.action_itemDetailFragment_to_timerFragment)
        }
    }
}