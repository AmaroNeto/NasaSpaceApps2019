package com.spacenasa04.main

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.spacenasa04.R
import com.spacenasa04.model.ActivityModel
import com.spacenasa04.view.GenericAdapter
import kotlinx.android.synthetic.main.main_activity.*
import kotlinx.android.synthetic.main.toolbar_main.*

class ListActivity: AppCompatActivity(), GenericAdapter.AppAdapterListener<ActivityModel> {

    override fun onItemClick(model: ActivityModel, position: Int) {
        var intent: Intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA, model)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_activity)

        setUpActionBar()
        setRecyclerView()

        loadActivities()
    }

    private fun setRecyclerView() {
        recyclerView.layoutManager =  LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.setHasFixedSize(true)
    }

    private fun setUpActionBar() {
        supportActionBar?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM)
        supportActionBar?.setDisplayShowCustomEnabled(true)
        supportActionBar?.setCustomView(R.layout.toolbar_main)
        toolbarTitle.text = getString(R.string.my_activities)

        val currentDate = "10-11-2045" // SimpleDateFormat("MM-dd-yyyy", /*Locale.getDefault()).format(Date()*/ "10-11-2045")
        toolbarInfo.text = currentDate
        toolbarSubtitle.text = "Europa, Jupiter Moon"
    }

    private fun loadActivities() {
        val item = ActivityModel("Rally in the desert of Europe",
            "https://4.bp.blogspot.com/-0oPuhbIWQoE/VjO7gCVbQlI/AAAAAAAABV8/-ZeExdjDtJA/s1600/The%2BMartian%2Bby%2BOleg%2BZherebin.jpg", "medium", "6 hour")
        val item2 = ActivityModel("See Hunicanes in Saturn",
            "https://www.thefactsite.com/wp-content/uploads/2013/07/saturn-hurricane.jpg", "easy", "2 hours")

        val item3 = ActivityModel("\n" +
                "Climbing in Cilix Crater",
            "https://thenypost.files.wordpress.com/2019/02/worst-mars-mission.jpg?quality=90&strip=all&w=618&h=410&crop=1", "hard", "8 hours")

        val item4 = ActivityModel("\n" +
                "Sunset in Conamara Chaos",
            "https://www.davidreneke.com/wp-content/uploads/2015/10/Walking-580x349.jpg", "easy", "2 hours")

        val item5 = ActivityModel("\n" +
                "Robot fight in Pwyll",
            "https://www.sciencenewsforstudents.org/sites/default/files/styles/large/public/scald-image/860_main_Marscolony.gif?itok=EUrvJalv", "medium", "6 hours")

        item.text = getString(R.string.lorem)
        item2.text = getString(R.string.text1)
        item3.text = getString(R.string.text2)
        item4.text = getString(R.string.text3)
        item5.text = getString(R.string.text4)

        val list = listOf<ActivityModel>(item, item2, item3, item4, item5)
        val adapter = GenericAdapter<ActivityModel>(list)
        adapter.listener = this
        recyclerView.adapter = adapter
    }
}