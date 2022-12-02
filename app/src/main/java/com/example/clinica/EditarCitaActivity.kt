package com.example.clinica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.clinica.databinding.ActivityEditarCitaBinding

class EditarCitaActivity : AppCompatActivity() {
    lateinit var binding: ActivityEditarCitaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditarCitaBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}