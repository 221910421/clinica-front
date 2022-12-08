package com.example.clinica.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.clinica.EditarMedicamentoActivity
import com.example.clinica.MedicamentoActivity
import com.example.clinica.R
import com.example.clinica.models.MedicamentosModel
import com.google.gson.Gson
import org.json.JSONObject

class MedicamentoViewHolder(view : View) : RecyclerView.ViewHolder(view) {
    val textNombre = view.findViewById<TextView>(R.id.txtNombre)
    val textClasificacion = view.findViewById<TextView>(R.id.txtClasificacion)
    val textPresentacion = view.findViewById<TextView>(R.id.txtPresentacion)
    val textDosis = view.findViewById<TextView>(R.id.txtDosis)
    val btnEditar = view.findViewById<TextView>(R.id.btnEditar)
    val btnBorrar = view.findViewById<TextView>(R.id.btnBorrar)

    fun render(item: MedicamentosModel){
        textNombre.text = item.nombre
        textClasificacion.text = item.clasificacion
        textPresentacion.text = item.presentacion
        textDosis.text = item.dosis
    }

    fun edit(medicamento:Int, cn: Context) {
        btnEditar.setOnClickListener {
            // Instantiate the RequestQueue.
            val queue = Volley.newRequestQueue(cn)
            val url = "https://clinicasanmiguel.com.mx/api/medicamentos/"+medicamento

            var Med : MedicamentosModel
            val stringRequest = StringRequest(
                Request.Method.GET, url,
                { response ->
                    val json = JSONObject(response)
                    var json2 = json.getJSONObject("response")
                    //Log.d("message", json2.toString())
                    Med = Gson().fromJson(json2.toString(), MedicamentosModel::class.java)

                    //Log.d("message", Act.toString())

                    val intent = Intent(cn, EditarMedicamentoActivity::class.java).apply {
                        putExtra("key",Med)
                    }

                    cn.startActivity(intent)
                },
                {
                    Log.d("message", "error")
                })
            queue.add(stringRequest)

        }
    }

    fun delet(id:Int, cn: Context) {
        btnBorrar.setOnClickListener {

            val queue = Volley.newRequestQueue(cn)
            val sr: StringRequest = object : StringRequest(
                Method.DELETE, "https://clinicasanmiguel.com.mx/api/medicamentos/"+id,
                Response.Listener { response ->
                    Log.d("message", response)
                },
                Response.ErrorListener { error ->
                    Log.d("message", "error $error")
                }) {
            }
            queue.add(sr)
            val intent = Intent(cn, MedicamentoActivity::class.java)
            startActivity(cn,intent,null)
                    }
    }

    }


