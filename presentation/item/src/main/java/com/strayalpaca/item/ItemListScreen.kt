package com.strayalpaca.item

import android.os.Bundle
import android.view.View
import androidx.core.net.toUri
import androidx.navigation.NavDeepLinkRequest
import com.strayalpaca.item.databinding.ItemListScreenBinding
import com.strayalpaca.presentation.ViewBindingFragment
import com.strayalpaca.presentation.navParam.Item
import com.strayalpaca.presentation.util.getParentNavController

class ItemListScreen : ViewBindingFragment<ItemListScreenBinding>(ItemListScreenBinding::bind, R.layout.item_list_screen) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initButton()
    }

    private fun initButton() {
        binding.btnMoveToDetail.setOnClickListener {
            // 이제 어떻게 parcelable 객체를 전달할 것인가?

            val testItem = Item(id = 10, title = "title of item")

            val request = NavDeepLinkRequest.Builder
                .fromUri("${getString(com.strayalpaca.presentation.R.string.deep_link_item_detail)}?item=${testItem}".toUri())
                .build()
            getParentNavController()?.navigate(request)
        }
    }
}