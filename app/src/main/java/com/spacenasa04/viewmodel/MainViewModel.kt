package com.spacenasa04.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.spacenasa04.model.PubliModel

class MainViewModel: ViewModel() {

    val response : MutableLiveData<List<PubliModel>> = MutableLiveData()

    init {
        loadData()
    }

    private fun loadData(){
        val result = mutableListOf<PubliModel>()
        result.add(PubliModel("New plants in space farm", "https://www.nasa.gov/sites/default/files/thumbnails/image/ksc-20181119-ph_csh01_0001_0.jpg"))
        result.add(PubliModel("Tomorrow: asteroid rain", "https://www.universetoday.com/wp-content/uploads/2017/08/twc_de_komet.jpg"))
        result.add(PubliModel("Mars found life", "https://tribktla.files.wordpress.com/2019/08/pia22106-thmfeat.jpg?quality=85&strip=all&w=400&h=225&crop=1"))
        result.add(PubliModel("New turistic point in Netuno", "https://render.fineartamerica.com/images/rendered/default/print/8.000/4.500/break/images-medium-5/weird-ice-planet-kirsty-pargeter.jpg"))

        response.value = result
    }

}