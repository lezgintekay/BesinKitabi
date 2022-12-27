package com.lezgintekay.besinkitabi.viewmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import com.lezgintekay.besinkitabi.model.Besin
import androidx.lifecycle.ViewModel

class BesinDetayiViewModel :ViewModel(){

    val besinLiveData = MutableLiveData<Besin>()


    fun roomVerisiniAl() {
        val muz = Besin("Muz", "100", "10","5","1", "www.test.com")
        besinLiveData.value = muz
    }

}