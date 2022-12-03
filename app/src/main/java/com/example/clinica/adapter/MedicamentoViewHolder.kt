package com.example.clinica.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.clinica.R

class MedicamentoViewHolder(view : View) : RecyclerView.ViewHolder(view) {
    val nombre = view.findViewById<TextView>(R.id.txtNombre)
    val descripcion = view.findViewById<TextView>(R.id.txtDescripcion)
    val dosis = view.findViewById<TextView>(R.id.txtDosis)
    val precio = view.findViewById<TextView>(R.id.txtPrecio)
}
