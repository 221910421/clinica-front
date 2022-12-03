package com.example.clinica.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "doctor")
data class DoctorModel(
    @PrimaryKey(autoGenerate = true)
    val ID: Int = 0,
    val Nombre:String,
    val Especialidad:String,
    val CedProf:String,
    val Password:String
): Serializable