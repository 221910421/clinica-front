package com.example.clinica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.clinica.adapter.MedicamentoAdapter
import com.example.clinica.databinding.ActivityMedicamentoBinding
import com.example.clinica.models.MedicamentosModel
import com.google.gson.Gson
import org.json.JSONObject

class MedicamentoActivity : AppCompatActivity() {
    lateinit var binding: ActivityMedicamentoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMedicamentoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getData()

        binding.btnCrearMedicamento.setOnClickListener{
            val intent = Intent(this, CrearMedicamento::class.java)
            startActivity(intent)
        }

    }

    fun getData() {
        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val url = "https://127.0.0.1:8000"

        var listaMedicamento = listOf<MedicamentosModel>()
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                val json = JSONObject(response)
                var json2 = json.getJSONArray("response")
                listaMedicamento = Gson().fromJson(json2.toString(), Array<MedicamentosModel>::class.java).toList()
                initRecyclerView(listaMedicamento)
            },
            {
                Log.d("message", "error")
            })
        queue.add(stringRequest)
    }

    fun initRecyclerView(Medicamentos: List<MedicamentosModel>) {
        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MedicamentoAdapter(Medicamentos,this)
    }
}