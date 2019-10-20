package com.spacenasa04.model

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.spacenasa04.R
import com.spacenasa04.view.AdapterModel

class PubliModel(val title: String, val url: String): AdapterModel {
    override fun layoutId(): Int {
        return R.layout.publi_item
    }

    override fun isFilterable(filter: String): Boolean {
        return false
    }

    companion object {
        @BindingAdapter("loadImage")
        @JvmStatic
        fun loadImage(view: ImageView, imageUrl: String) {
            Glide.with(view.getContext())
                .load(imageUrl)
                .centerCrop()
                .into(view)
        }
    }

}