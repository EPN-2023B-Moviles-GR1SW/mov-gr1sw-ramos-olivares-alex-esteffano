package com.example.examen_grsw1_aero


import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.FileWriter

class DeleteActivity : AppCompatActivity() {

    private lateinit var medListView: ListView
    private lateinit var medList: MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete)

        medListView = findViewById(R.id.medListView)
        medList = mutableListOf()

        loadMedList()

        medListView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, medList)
        medListView.setOnItemClickListener { _, _, position, _ ->
            deleteMedicine(position)
        }
    }

    private fun loadMedList() {
        val file = File(filesDir, "medicines.txt")
        if (file.exists()) {
            BufferedReader(FileReader(file)).useLines { lines ->
                lines.forEach { medList.add(it) }
            }
        }
    }

    private fun deleteMedicine(position: Int) {
        if (position in 0 until medList.size) {
            medList.removeAt(position)
            updateMedicineFile()
            (medListView.adapter as ArrayAdapter<*>).notifyDataSetChanged()
        }
    }

    private fun updateMedicineFile() {
        val file = File(filesDir, "medicines.txt")
        FileWriter(file).use { writer ->
            medList.forEach { writer.write("$it\n") }
        }
    }
}
