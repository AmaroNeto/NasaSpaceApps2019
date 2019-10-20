package com.spacenasa04.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.spacenasa04.R
import com.spacenasa04.model.PubliModel
import com.spacenasa04.view.GenericAdapter
import com.spacenasa04.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.main_activity.*
import kotlinx.android.synthetic.main.toolbar_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity: AppCompatActivity() {

    lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        vm = ViewModelProviders.of(this).get(MainViewModel::class.java)

        setUpActionBar()
        setRecyclerView()
        setupView()

        cardView.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }
    }
    
    fun setupView() {
        vm.response.observe( this, Observer { response -> processResponse(response) })
    }

    private fun setRecyclerView() {
        recyclerView.layoutManager =  LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.setHasFixedSize(true)
    }

    private fun processResponse(response: List<PubliModel>?) {
        response?.let {
            val adapter = GenericAdapter<PubliModel>(response)
            recyclerView.adapter = adapter
        }
    }

    private fun setUpActionBar() {
        supportActionBar?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM)
        supportActionBar?.setDisplayShowCustomEnabled(true)
        supportActionBar?.setCustomView(R.layout.toolbar_main)
        toolbarTitle.text = getString(R.string.app_name)

        val currentDate = "10-11-2045"// SimpleDateFormat("MM-dd-yyyy", /*Locale.getDefault()).format(Date()*/ "10-11-2045")
        toolbarInfo.text = currentDate
        toolbarSubtitle.text = "Europa, Jupiter Moon"
    }

}