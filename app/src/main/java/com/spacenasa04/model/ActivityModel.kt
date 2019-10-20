package com.spacenasa04.model

import com.spacenasa04.view.AdapterModel
import androidx.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.spacenasa04.R
import java.io.Serializable


class ActivityModel(val title: String, val url: String, val level: String, val time: String): AdapterModel, Serializable {

    var text: String = ""

    override fun layoutId(): Int {
        return R.layout.activity_item
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