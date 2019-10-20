package com.spacenasa04.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.spacenasa04.R
import com.spacenasa04.databinding.ActivityDetailBinding
import com.spacenasa04.model.ActivityModel
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.toolbar_main.*

class DetailActivity: AppCompatActivity() {

    companion object {
        const val EXTRA = "EXTRA"
    }

    var data: ActivityModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        data = intent.getSerializableExtra(EXTRA) as ActivityModel?

        val binding: ActivityDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        data?.let {
            binding.model = data
        }

        booking.setOnClickListener {
            Toast.makeText(this, "Activity booked", Toast.LENGTH_LONG).show()
            finish()
        }

        setUpActionBar()
    }

    private fun setUpActionBar() {
        supportActionBar?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM)
        supportActionBar?.setDisplayShowCustomEnabled(true)
        supportActionBar?.setCustomView(R.layout.toolbar_main)
        data?.let {
            toolbarTitle.text = it.title
        }

        val currentDate = "10-11-2045" // SimpleDateFormat("MM-dd-yyyy", /*Locale.getDefault()).format(Date()*/ "10-11-2045")
        toolbarInfo.text = currentDate
        toolbarSubtitle.text = "Activity"
    }


}