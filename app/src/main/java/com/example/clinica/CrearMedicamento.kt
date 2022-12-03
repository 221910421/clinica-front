package com.example.clinica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.clinica.databinding.ActivityCrearMedicamentoBinding

class CrearMedicamento : AppCompatActivity() {
    lateinit var binding : ActivityCrearMedicamentoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCrearMedicamentoBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}