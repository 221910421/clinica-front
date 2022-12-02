package com.example.clinica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.clinica.adapter.CitaAdapter
import com.example.clinica.config.AppDatabase
import com.example.clinica.databinding.ActivityCitaBinding
import com.example.clinica.models.CitaModel

class CitaActivity : AppCompatActivity() {

    lateinit var binding: ActivityCitaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCitaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()

        binding.btnCrearCita.setOnClickListener {
            val intent = Intent(this, CrearCitaActivity::class.java)
            startActivity(intent)
        }

    }

    fun initRecyclerView(){
        val recyclerView = binding.ListaCita
        recyclerView.layoutManager = LinearLayoutManager(this)

        var Citas = emptyList<CitaModel>()

        var database = AppDatabase.getDatabase(this)

        Citas = database.citas().getAll()

        Log.d("message", Citas.toString())

        recyclerView.adapter = CitaAdapter(Citas,this)

    }
}