package com.senix22.firstproject.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.senix22.firstproject.R
import com.senix22.firstproject.WinnersData

class WinnersAdapter(private val items: ArrayList<WinnersData>) :
    RecyclerView.Adapter<WinnersViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WinnersViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.winners_view_holder, parent, false)
        return WinnersViewHolder(view)
    }

    override fun onBindViewHolder(holder: WinnersViewHolder, position: Int) {
        holder.bind(items[position].toString())
    }

    override fun getItemCount(): Int {
        return items.count()
    }
}