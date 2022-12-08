package com.example.clinica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.clinica.databinding.ActivityEditarMedicamentoBinding
import com.example.clinica.models.MedicamentosModel

class EditarMedicamentoActivity : AppCompatActivity() {
    lateinit var binding: ActivityEditarMedicamentoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditarMedicamentoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val Med = intent.getSerializableExtra("key") as MedicamentosModel

        binding.txtNombre.setText(Med.nombre)
        binding.txtClasificacion.setText(Med.clasificacion)
        binding.txtPresentacion.setText(Med.presentacion)
        binding.txtDosis.setText(Med.dosis)

        binding.btnGuardar.setOnClickListener{

            val queue = Volley.newRequestQueue(this)
            val sr: StringRequest = object : StringRequest(
                Method.PUT, "https://clinicasanmiguel.com.mx/api/medicamentos/"+Med.id.toString()+"?"+"nombre="+binding.txtNombre.text.toString()+"&clasificacion="+binding.txtClasificacion.text.toString()+"&presentacion="+binding.txtPresentacion.text.toString()+"&dosis="+binding.txtDosis.text.toString(),
                Response.Listener { response ->
                    Log.d("message", response)
                },
                Response.ErrorListener { error ->
                    Log.d("message", "error $error")
                }) {
                override fun getParams(): Map<String, String> {
                    val params: MutableMap<String, String> = HashMap()
                    params["id"] = Med.id.toString()
                    params["nombre"] = binding.txtNombre.text.toString()
                    params["clasificacion"] =  binding.txtClasificacion.text.toString()
                    params["presentacion"] = binding.txtPresentacion.text.toString()
                    params["dosis"] = binding.txtDosis.text.toString()
                    Log.d("message", params.toString())
                    return params
                }

            }
            queue.add(sr)
            val intent = Intent(this, MedicamentoActivity::class.java)
            startActivity(intent)
        }

    }
}