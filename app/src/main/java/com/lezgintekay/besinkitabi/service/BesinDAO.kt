package com.lezgintekay.besinkitabi.service

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.lezgintekay.besinkitabi.model.Besin
@Dao
interface BesinDAO {



    @Insert
     fun insertAll(vararg besin : Besin) : List<Long>

    @Query("SELECT * FROM besin")
     fun getAllBesin() : List<Besin>

    @Query("SELECT * FROM besin WHERE uuid = :besinId")
     fun getBesin(besinId : Int) : Besin

    @Query("DELETE FROM besin")
    fun deleteAllBesin()


}