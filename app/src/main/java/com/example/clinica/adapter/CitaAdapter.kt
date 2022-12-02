package com.example.clinica.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.clinica.R
import com.example.clinica.models.CitaModel

class CitaAdapter(private val ListaCita: List<CitaModel>, cn: Context) : RecyclerView.Adapter<CitaViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CitaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CitaViewHolder(layoutInflater.inflate(R.layout.item_cita, parent, false))
    }

    val cpn = cn

    override fun onBindViewHolder(holder: CitaViewHolder, position: Int) {
        val item = ListaCita[position]
        holder.render(item)
        holder.edit(item.ID, cpn)
        holder.delet(item, cpn)
    }

    override fun getItemCount(): Int = ListaCita.size
}