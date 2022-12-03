package com.example.clinica.api

import com.android.volley.Response
import retrofit2.http.GET

interface ApiService {
    @get:GET("medicamentos/")
    val medicamentos: Response<MedicamentosResponse>
}