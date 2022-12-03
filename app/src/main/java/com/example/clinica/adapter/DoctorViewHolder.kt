package com.example.clinica.adapter

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.clinica.*
import com.example.clinica.config.AppDatabase
import com.example.clinica.models.DoctorModel

class DoctorViewHolder(view:View) : RecyclerView.ViewHolder(view) {
    val TextDoctor = view.findViewById<TextView>(R.id.txtNombre)
    val BtnEditar = view.findViewById<TextView>(R.id.btnEditarDoctor)
    val BtnBorrar = view.findViewById<TextView>(R.id.btnBorrarDoctor)

    fun render(doctor: DoctorModel){
        TextDoctor.text = doctor.Nombre
    }

    fun edit(doctor: Int,cn: Context){
        BtnEditar.setOnClickListener{
            var database = AppDatabase.getDatabase(itemView.context)

            var doc=database.doctores().get(doctor)

            val intent = Intent(cn, EditarDoctorActivity::class.java).apply {
                putExtra("key",doc)
            }

            cn.startActivity(intent)
        }
    }

    fun delet(doctor: DoctorModel, cn: Context){
        BtnBorrar.setOnClickListener{
            var database = AppDatabase.getDatabase(cn)

            database.doctores().delete(doctor)

            val intent = Intent(cn, DoctorActivity::class.java)
            cn.startActivity(intent)
        }
    }

}