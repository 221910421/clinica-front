package com.example.clinica.dao

import androidx.room.*
import com.example.clinica.models.CitaModel

@Dao

interface CitasDao {
    @Query("SELECT * FROM cita")
    fun getAll():List<CitaModel>

    @Query("SELECT * FROM cita WHERE ID = :id")
    fun get(id:Int):CitaModel

    @Insert
    fun insert(vararg cita: CitaModel)

    @Update
    fun update(vararg cita: CitaModel)

    @Delete
    fun delete(vararg cita: CitaModel)

}