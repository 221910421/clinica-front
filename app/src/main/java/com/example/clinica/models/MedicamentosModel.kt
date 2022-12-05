package com.example.clinica.models

import java.io.Serializable

data class MedicamentosModel(
    val id: Int,
    val nombre: String,
    val clasificacion: String,
    val presentacion: String,
    val dosis: String
): Serializable
