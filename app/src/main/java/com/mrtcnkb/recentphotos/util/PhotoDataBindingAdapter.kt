package com.mrtcnkb.recentphotos.util

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.mrtcnkb.recentphotos.R

/**
 * Created by MuratCan on 6.05.2020.
 */

@BindingAdapter("loadImage")
fun setPhoto(imageView: ImageView, url: String) {
    Glide.with(imageView.context)
        .load(url)
        .apply(RequestOptions().placeholder(R.drawable.gradiend_placeholder))
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(imageView)
}

@BindingAdapter("visibleIf")
fun changeVisibility(view: View, visible: Boolean) {
    view.visibility = if (visible) View.VISIBLE else View.GONE
}
