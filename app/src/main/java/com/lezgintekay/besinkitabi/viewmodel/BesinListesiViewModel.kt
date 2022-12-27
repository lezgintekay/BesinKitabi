package com.lezgintekay.besinkitabi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lezgintekay.besinkitabi.model.Besin
import com.lezgintekay.besinkitabi.service.BesinAPIService
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers


class BesinListesiViewModel : ViewModel() {

    val besinler = MutableLiveData<List<Besin>?>()
    val besinHataMesaji = MutableLiveData<Boolean>()
    val besinYukleniyor = MutableLiveData<Boolean>()

    private val besinApiServis = BesinAPIService ()
    private val disposable = CompositeDisposable()

    fun refreshData(){

        verileriInternettenAl()

    }

    private fun verileriInternettenAl(){

        besinYukleniyor.value = true
        disposable.add(
            besinApiServis.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Besin>>(),
                    SingleObserver<List<Besin>> {
                    override fun onSuccess(value: List<Besin>) {

                        besinler.value = value
                        besinHataMesaji.value = false
                        besinYukleniyor.value = false

                    }

                    override fun onError(e: Throwable) {

                        besinHataMesaji.value = true
                        besinYukleniyor.value = false

                    }




                })




        )







    }
}