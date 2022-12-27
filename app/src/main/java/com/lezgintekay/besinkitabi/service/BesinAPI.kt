package com.lezgintekay.besinkitabi.service

import com.lezgintekay.besinkitabi.model.Besin
import io.reactivex.Single
import retrofit2.http.GET


interface BesinAPI {

    //https://raw.githubusercontent.com/atilsamancioglu/BTK20-JSONVeriSeti/master/besinler.json

    @GET ("atilsamancioglu/BTK20-JSONVeriSeti/master/besinler.json")

// Call<List<Repo>> listRepos(@Path("user") String user);
fun getBesin() : Single<List<Besin>>


}