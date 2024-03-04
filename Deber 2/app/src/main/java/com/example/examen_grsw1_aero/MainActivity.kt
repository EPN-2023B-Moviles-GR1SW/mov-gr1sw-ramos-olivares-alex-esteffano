package com.example.examen_grsw1_aero

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.FileWriter

class MainActivity : AppCompatActivity() {

    private lateinit var createMedNameEditText: EditText
    private lateinit var addButton: Button
    private lateinit var deleteButton: Button
    private lateinit var listButton: Button
    private lateinit var medListView: ListView

    private val medList = mutableListOf<String>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createMedNameEditText = findViewById(R.id.createMedNameEditText)
        addButton = findViewById(R.id.addButton)
        deleteButton = findViewById(R.id.deleteButton)
        listButton = findViewById(R.id.listButton)
        medListView = findViewById(R.id.medListView)

        loadMedList()

        addButton.setOnClickListener {
            val medName = createMedNameEditText.text.toString()
            if (medName.isNotEmpty()) {
                addMedicine(medName)
                createMedNameEditText.text.clear()
            }
        }

        deleteButton.setOnClickListener {
            startActivity(DeleteActivity::class.java)
        }

        listButton.setOnClickListener {
            startActivity(ListActivity::class.java)
        }

        medListView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, medList)
        medListView.setOnItemLongClickListener { _, _, position, _ ->
            deleteMedicine(position)
            true
        }

        val botonSqlite = findViewById<Button>(R.id.sqlite)
        botonSqlite
            .setOnClickListener {
                irActividad(ECrudEntrenador::class.java)
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

    private fun addMedicine(medName: String) {
        medList.add(medName)
        updateMedicineFile()
        (medListView.adapter as ArrayAdapter<*>).notifyDataSetChanged()
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

    private fun <T> startActivity(activity: Class<T>) {
        val intent = Intent(this, activity)
        startService(intent)
    }

    fun irActividad(
        clase: Class<*>
    ){
        val intent = Intent(this, clase)
        startActivity(intent)
    }
}

