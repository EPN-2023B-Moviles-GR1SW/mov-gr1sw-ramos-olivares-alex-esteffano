package com.example.examen_grsw1_aero


import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.File
import java.io.FileReader

class ListActivity : AppCompatActivity() {

    private lateinit var medListView: ListView
    private lateinit var medList: MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        medListView = findViewById(R.id.medListView)
        medList = mutableListOf()

        loadMedList()

        medListView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, medList)
    }

    private fun loadMedList() {
        val file = File(filesDir, "medicines.txt")
        if (file.exists()) {
            BufferedReader(FileReader(file)).useLines { lines ->
                lines.forEach { medList.add(it) }
            }
        }
    }
}
