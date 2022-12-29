package com.lezgintekay.besinkitabi.viewmodel

import android.app.Application
import android.view.View
import androidx.lifecycle.MutableLiveData
import com.lezgintekay.besinkitabi.model.Besin
import androidx.lifecycle.ViewModel
import com.lezgintekay.besinkitabi.service.BesinDatabase
import kotlinx.coroutines.launch

class BesinDetayiViewModel(application: Application) :BaseViewModel(application){

    val besinLiveData = MutableLiveData<Besin>()


    fun roomVerisiniAl(uuid :Int) {
        launch {
            val dao = BesinDatabase(getApplication()).besinDao()
            val besin = dao.getBesin(uuid)
            besinLiveData.value =besin
        }
    }

}