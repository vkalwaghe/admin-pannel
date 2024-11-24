package com.example.adminpanel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.admin_panel.R

class DashboardAdapter(
    private val options: List<DashboardOption>,
    private val onItemClick: (DashboardOption) -> Unit
) : RecyclerView.Adapter<DashboardAdapter.DashboardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_dashboard_option, parent, false)
        return DashboardViewHolder(view)
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        val option = options[position]
        holder.bind(option)
        holder.itemView.setOnClickListener { onItemClick(option) }
    }

    override fun getItemCount(): Int = options.size

    class DashboardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val iconView: ImageView = itemView.findViewById(R.id.iconImageView)
        private val titleView: TextView = itemView.findViewById(R.id.titleTextView)

        fun bind(option: DashboardOption) {
            iconView.setImageResource(option.iconResId)
            titleView.text = option.title
        }
    }
}
