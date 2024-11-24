package com.example.adminpanel

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.admin_panel.ManageCarsActivity
import com.example.admin_panel.ManageDriversActivity
import com.example.admin_panel.R
import com.example.admin_panel.ViewBookingsActivity

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        // RecyclerView for dashboard options
        val dashboardRecyclerView: RecyclerView = findViewById(R.id.dashboardRecyclerView)
        dashboardRecyclerView.layoutManager = GridLayoutManager(this, 2) // 2 columns

        // List of dashboard options
        val dashboardOptions = listOf(
            DashboardOption("Manage Cars", R.drawable.ic_manage_car),
            DashboardOption("Manage Drivers", R.drawable.ic_manage_driver),
            DashboardOption("View Bookings", R.drawable.ic_manage_booking)
        )

        // Adapter for RecyclerView
        val adapter = DashboardAdapter(dashboardOptions) { option ->
            when (option.title) {
                "Manage Cars" -> {
                    val intent = Intent(this, ManageCarsActivity::class.java)
                    startActivity(intent)
                }
                "Manage Drivers" -> {
                    val intent = Intent(this, ManageDriversActivity::class.java)
                    startActivity(intent)
                }
                "View Bookings" -> {
                    val intent = Intent(this, ViewBookingsActivity::class.java)
                    startActivity(intent)
                }
            }
        }
        dashboardRecyclerView.adapter = adapter
    }
}
