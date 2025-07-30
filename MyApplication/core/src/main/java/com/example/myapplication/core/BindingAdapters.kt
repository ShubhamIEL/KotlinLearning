package com.example.myapplication.core

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("app:isVisible")
fun setVisible(view: View, isVisible: Boolean) {
    view.visibility = if (isVisible) View.VISIBLE else View.GONE
}