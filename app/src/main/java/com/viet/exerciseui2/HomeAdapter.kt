package com.viet.exerciseui2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HomeAdapter(var arrayListHome: ArrayList<Home>) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvname : TextView = view.findViewById(R.id.tvname)
        var tvnumber : TextView = view.findViewById(R.id.tvnumber)
        var tvplace : TextView = view.findViewById(R.id.tvplace)
        var tvtime : TextView = view.findViewById(R.id.tvtime)
        var tvnumplus : TextView = view.findViewById(R.id.tvnumplus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerviewmenu, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(holder != null){
            holder.tvname.text = arrayListHome[position].name
            holder.tvnumber.text = arrayListHome[position].number
            holder.tvplace.text = arrayListHome[position].place
            holder.tvtime.text = arrayListHome[position].time
            holder.tvnumplus.text = arrayListHome[position].numplus
        }
    }

    override fun getItemCount(): Int {
        return arrayListHome.size
    }
}