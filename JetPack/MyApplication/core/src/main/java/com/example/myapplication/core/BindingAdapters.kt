package com.example.myapplication.core

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@BindingAdapter("app:isVisible")
fun setVisible(view: View, isVisibleFlow: StateFlow<Boolean>?) {
    // Find the LifecycleOwner associated with the view
    val lifecycleOwner = view.findViewTreeLifecycleOwner() ?: return
    isVisibleFlow ?: return

    // Launch a coroutine that is tied to the view's lifecycle
    lifecycleOwner.lifecycleScope.launch {
        // Collect the latest value from the StateFlow
        isVisibleFlow.collectLatest { isVisible ->
            // Update the view's visibility
            view.visibility = if (isVisible) View.VISIBLE else View.GONE
        }
    }
}