package com.example.clinica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.clinica.config.AppDatabase
import com.example.clinica.databinding.ActivityCrearCitaBinding
import com.example.clinica.models.CitaModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CrearCitaActivity : AppCompatActivity() {
    lateinit var binding: ActivityCrearCitaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCrearCitaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGuardar.setOnClickListener {
            var cit: CitaModel = getAllData()

            var database = AppDatabase.getDatabase(this)
            CoroutineScope(Dispatchers.IO).launch {
                database.citas().insert(cit)
            }

            println(cit)

            val intent = Intent(this, CitaActivity::class.java)
            startActivity(intent)
        }
    }

    fun getAllData(): CitaModel {
        var cita: CitaModel = CitaModel(
            0,
            binding.txtNombre.text.toString(),
            binding.txtDescripcion.text.toString(),
            binding.txtFecha.text.toString(),
            binding.txtHora.text.toString()
        )
        return cita
    }
}