package com.senix22.firstproject.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.winners_view_holder.view.*


class WinnersViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(myItem: String) {
        itemView.winners_name_textView.text = myItem
    }
}