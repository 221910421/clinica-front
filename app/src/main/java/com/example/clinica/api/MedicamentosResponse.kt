package com.example.clinica.api

import com.google.gson.annotations.SerializedName

data class MedicamentosResponse(
    @SerializedName("success") var success:String,
    @SerializedName("response")var response:List<String>
    )
