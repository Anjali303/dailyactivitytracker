package com.example.dailyactivitytracker

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button)
        val spinner: Spinner = findViewById(R.id.spinner)
        val textView: TextView = findViewById(R.id.textView)

        // Spinner data
        val activities = arrayOf("Walking", "Running", "Cycling", "Swimming")

        // Create an adapter
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, activities)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Set adapter to spinner
        spinner.adapter = adapter

        // Set Spinner OnItemSelectedListener
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val selectedActivity = activities[position]
                textView.text = "Selected activity: $selectedActivity"
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                textView.text = "No activity selected"
            }
        }

        // Set Button OnClickListener
        button.setOnClickListener {
            val selectedActivity = spinner.selectedItem.toString()
            Toast.makeText(this, "$selectedActivity logged!", Toast.LENGTH_SHORT).show()
        }
    }
}
