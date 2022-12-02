package com.example.clinica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.clinica.config.AppDatabase
import com.example.clinica.databinding.ActivityEditarCitaBinding
import com.example.clinica.models.CitaModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EditarCitaActivity : AppCompatActivity() {
    lateinit var binding: ActivityEditarCitaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditarCitaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val cita = intent.getSerializableExtra("key") as CitaModel

        val textNombre: TextView = binding.txtNombre
        textNombre.text = cita.Nombre

        val textDescripcion: TextView = binding.txtDescripcion
        textDescripcion.text = cita.Descripcion

        val textFC: TextView = binding.txtFecha
        textFC.text = cita.Fecha

        val textFT: TextView = binding.txtHora
        textFT.text = cita.Hora

        binding.btnGuardar.setOnClickListener{
            var cit : CitaModel = getAllData(cita.ID)

            var database = AppDatabase.getDatabase(this)

            Log.d("message",cit.toString())

            CoroutineScope(Dispatchers.IO).launch {
                database.citas().update(cit)
            }

            val intent = Intent(this, CitaActivity::class.java)
            startActivity(intent)
        }
    }

    fun getAllData(id:Int): CitaModel
    {
        var cita : CitaModel =
            CitaModel(id,
                binding.txtNombre.text.toString(),
                binding.txtDescripcion.text.toString(),
                binding.txtFecha.text.toString(),
                binding.txtHora.text.toString())
        return cita
    }
}