package com.example.clinica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.clinica.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {

    lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCitas.setOnClickListener {
            val intent = Intent(this, CitaActivity::class.java)
            startActivity(intent)
        }

        binding.btnDoctores.setOnClickListener {
            val intent = Intent(this, DoctorActivity::class.java)
            startActivity(intent)
        }

        binding.btnMedicamentos.setOnClickListener {
            val intent = Intent(this, MedicamentoActivity::class.java)
            startActivity(intent)
        }

    }
}