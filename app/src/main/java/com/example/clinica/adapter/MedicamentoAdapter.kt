package com.example.clinica.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.clinica.R
import com.example.clinica.models.MedicamentosModel

class MedicamentoAdapter(private val listaMedicamento:List<MedicamentosModel>,cn: Context) : RecyclerView.Adapter<MedicamentoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicamentoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MedicamentoViewHolder(layoutInflater.inflate(R.layout.item_api,parent,false))
    }

    val cpn = cn

    override fun onBindViewHolder(holder: MedicamentoViewHolder, position: Int) {
        val item = listaMedicamento[position]
        holder.render(item)
        holder.edit(item.id,cpn)
        holder.delet(item.id,cpn)
    }

    override fun getItemCount(): Int = listaMedicamento.size

}