package com.example.clinica.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "cita")
data class CitaModel(
    @PrimaryKey(autoGenerate = true)
    val ID: Int = 0,
    val Nombre:String,
    val Descripcion:String,
    val Fecha:String,
    val Hora:String
): Serializable