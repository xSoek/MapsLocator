package com.example.retomapssave.Dao


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LocationDao {

    @Query("SELECT * FROM location")
    //Suspend ejecuta la funcion en segundo plano, de lo contrario petaria el compilador
    suspend fun getAll(): List<Location>

    @Insert
    suspend fun insert(location: Location)
}