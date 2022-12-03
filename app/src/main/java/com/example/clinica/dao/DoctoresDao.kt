package com.example.clinica.dao

import androidx.room.*
import com.example.clinica.models.DoctorModel

@Dao

interface DoctoresDao {
    @Query("SELECT * FROM doctor")
    fun getAll():List<DoctorModel>

    @Query("SELECT * FROM doctor WHERE ID = :id")
    fun get(id:Int):DoctorModel

    @Insert
    fun insert(vararg doctor: DoctorModel)

    @Update
    fun update(vararg doctor: DoctorModel)

    @Delete
    fun delete(vararg doctor: DoctorModel)

}