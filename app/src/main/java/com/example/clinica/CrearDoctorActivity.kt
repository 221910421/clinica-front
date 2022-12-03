package com.example.clinica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.clinica.config.AppDatabase
import com.example.clinica.databinding.ActivityCrearDoctorBinding
import com.example.clinica.models.DoctorModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CrearDoctorActivity : AppCompatActivity() {
    lateinit var binding: ActivityCrearDoctorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCrearDoctorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGuardar.setOnClickListener{
            var doc: DoctorModel = getAllData()

            var database = AppDatabase.getDatabase(this)
            CoroutineScope(Dispatchers.IO).launch {
                database.doctores().insert(doc)
            }

            println(doc)

            val intent = Intent(this, DoctorActivity::class.java)
            startActivity(intent)

        }
    }

    fun getAllData(): DoctorModel {
        var doctor: DoctorModel = DoctorModel(
            0,
            binding.txtNombre.text.toString(),
            binding.txtEspecialidad.text.toString(),
            binding.txtCedula.text.toString(),
            binding.txtPassword.text.toString()
        )
        return doctor
    }
}