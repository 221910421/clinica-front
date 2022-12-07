package com.example.clinica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.clinica.databinding.ActivityCrearMedicamentoBinding

class CrearMedicamento : AppCompatActivity() {
    lateinit var binding: ActivityCrearMedicamentoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCrearMedicamentoBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnGuardar.setOnClickListener {
            val queue = Volley.newRequestQueue(this)
            val sr: StringRequest =
                object : StringRequest(Method.POST, "https://clinicasanmiguel.com.mx/api/medicamentos",
                    Response.Listener { response ->
                        Log.d("message", response)
                    },
                    Response.ErrorListener { error ->
                        Log.d("message", "error $error")
                    }) {
                    override fun getParams(): Map<String, String> {
                        val params: MutableMap<String, String> = HashMap()
                        params["nombre"] = binding.txtNombre.text.toString()
                        params["clasicacion"] = binding.txtClasificacion.text.toString()
                        params["presentacion"] = binding.txtPresentacion.text.toString()
                        params["dosis"] = binding.txtDosis.text.toString()
                        //Log.d("message", params.toString())
                        return params
                    }
                }
            queue.add(sr)
            val intent = Intent(this, MedicamentoActivity::class.java)
            startActivity(intent)
        }
    }
}