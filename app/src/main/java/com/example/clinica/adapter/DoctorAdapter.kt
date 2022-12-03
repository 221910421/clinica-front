package com.example.clinica.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.clinica.R
import com.example.clinica.models.DoctorModel

class DoctorAdapter(private val ListaDoctor: List<DoctorModel>, cn: Context) : RecyclerView.Adapter<DoctorViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return DoctorViewHolder(layoutInflater.inflate(R.layout.item_doctor, parent, false))
    }

    val cpn = cn

    override fun onBindViewHolder(holder: DoctorViewHolder, position: Int) {
        val item = ListaDoctor[position]
        holder.render(item)
        holder.edit(item.ID, cpn)
        holder.delet(item, cpn)
    }

    override fun getItemCount(): Int = ListaDoctor.size
}