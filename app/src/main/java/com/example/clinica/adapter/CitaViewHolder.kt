package com.example.clinica.adapter

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.clinica.CitaActivity
import com.example.clinica.EditarCitaActivity
import com.example.clinica.MenuActivity
import com.example.clinica.R
import com.example.clinica.config.AppDatabase
import com.example.clinica.models.CitaModel

class CitaViewHolder (view: View) : RecyclerView.ViewHolder(view){
    val TextCita = view.findViewById<TextView>(R.id.txtNombre)
    val btnEditar = view.findViewById<Button>(R.id.btnEditarCita)
    val btnBorrar = view.findViewById<Button>(R.id.btnBorrarCita)

    fun render(cita: CitaModel){
        TextCita.text = cita.Nombre
    }

    fun edit(cita: Int,cn: Context){
        btnEditar.setOnClickListener{
            var database = AppDatabase.getDatabase(cn)

            //Log.d("message", cita.toString())
            var cit=database.citas().get(cita)
            //Log.d("message", cit.toString())

            val intent = Intent(cn, EditarCitaActivity::class.java).apply {
                putExtra("key",cit)
            }

            cn.startActivity(intent)
        }
    }

    fun delet(cita: CitaModel,cn: Context){
        btnBorrar.setOnClickListener{
            var database = AppDatabase.getDatabase(cn)

            database.citas().delete(cita)

            val intent = Intent(cn, CitaActivity::class.java)
            cn.startActivity(intent)
        }
    }

}