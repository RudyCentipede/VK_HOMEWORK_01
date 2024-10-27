package com.example.android.vk_edu

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RectangleAdapter(private val context: Context, private val numbers: List<Int>, private val columns: Int) :
    RecyclerView.Adapter<RectangleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_rectangle, parent, false)
        val layoutParams = view.layoutParams
        layoutParams.width = parent.width / columns
        layoutParams.height = layoutParams.width
        view.layoutParams = layoutParams
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val number = numbers[position]
        holder.tvNumber.text = number.toString()
        holder.tvNumber.setBackgroundColor(
            if (number % 2 == 0)
                context.resources.getColor(android.R.color.holo_red_light)
            else
                context.resources.getColor(android.R.color.holo_blue_light)
        )
    }

    override fun getItemCount(): Int {
        return numbers.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNumber: TextView = itemView.findViewById(R.id.tvNumber)
    }
}