package com.example.clinica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.clinica.config.AppDatabase
import com.example.clinica.databinding.ActivityEditarDoctorBinding
import com.example.clinica.models.DoctorModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EditarDoctorActivity : AppCompatActivity() {
    lateinit var binding: ActivityEditarDoctorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditarDoctorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val doctor = intent.getSerializableExtra("key") as DoctorModel

        val textNombre: TextView = binding.txtNombre
        textNombre.text = doctor.Nombre

        val textEspecialidad: TextView = binding.txtEspecialidad
        textEspecialidad.text = doctor.Especialidad

        val textCedula: TextView = binding.txtCedula
        textCedula.text = doctor.CedProf

        val textContraseña: TextView = binding.txtPassword
        textContraseña.text = doctor.Password

        binding.btnGuardar.setOnClickListener{
            var doc : DoctorModel = getAllData(doctor.ID)

            var database = AppDatabase.getDatabase(this)

            Log.d("message",doc.toString())

            CoroutineScope(Dispatchers.IO).launch {
                database.doctores().update(doc)
            }

            val intent = Intent(this, DoctorActivity::class.java)
            startActivity(intent)
        }

    }

    fun getAllData(id:Int): DoctorModel
    {
        var doctor : DoctorModel =
            DoctorModel(id,
                binding.txtNombre.text.toString(),
                binding.txtEspecialidad.text.toString(),
                binding.txtCedula.text.toString(),
                binding.txtPassword.text.toString())
        return doctor
    }

}