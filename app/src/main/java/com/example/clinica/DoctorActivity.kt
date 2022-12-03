package com.example.clinica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.clinica.adapter.DoctorAdapter
import com.example.clinica.config.AppDatabase
import com.example.clinica.databinding.ActivityDoctorBinding
import com.example.clinica.models.DoctorModel

class DoctorActivity : AppCompatActivity() {
    lateinit var binding: ActivityDoctorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDoctorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        InitRecyclerView()

        binding.btnCrearDoctor.setOnClickListener{
            val intent = Intent(this, CrearDoctorActivity::class.java)
            startActivity(intent)
        }

    }

    fun InitRecyclerView(){
        val recyclerView = binding.ListaDoctor
        recyclerView.layoutManager = LinearLayoutManager(this)

        var Doctores = emptyList<DoctorModel>()

        var database = AppDatabase.getDatabase(this)

        Doctores = database.doctores().getAll()

        Log.d("message", Doctores.toString())

        recyclerView.adapter = DoctorAdapter(Doctores,this)
    }
}