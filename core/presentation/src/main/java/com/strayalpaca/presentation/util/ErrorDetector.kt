package com.strayalpaca.presentation.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

object ErrorDetector {
    private val _tokenExpired = MutableSharedFlow<Boolean>()
    val tokenExpired = _tokenExpired.asSharedFlow()

    fun setTokenExpired() {
        CoroutineScope(Dispatchers.Default).launch {
            _tokenExpired.emit(true)
        }
    }
}