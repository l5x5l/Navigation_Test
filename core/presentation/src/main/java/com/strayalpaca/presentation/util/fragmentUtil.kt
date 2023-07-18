package com.strayalpaca.presentation.util

import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController

fun Fragment.getParentNavController() : NavController? {
    var parent = parentFragment
    var navController : NavController?= null
    while (parent != null) {
        navController = parent.findNavController()
        parent = parent.parentFragment
    }
    return navController
}