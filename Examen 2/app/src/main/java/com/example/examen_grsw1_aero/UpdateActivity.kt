package com.example.examen_grsw1_aero

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.FileWriter

class UpdateActivity : AppCompatActivity() {
    object listaMedicinas {

    }

    private lateinit var updateMedNameEditText: EditText
    private lateinit var updateButton: Button

    private var selectedItemPosition: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        updateMedNameEditText = findViewById(R.id.updateMedNameEditText)
        updateButton = findViewById(R.id.updateButton)

        selectedItemPosition = intent.getIntExtra("position", -1)

        if (selectedItemPosition != -1) {
            updateMedNameEditText.setText(getMedicine(selectedItemPosition))
        }

        updateButton.setOnClickListener {
            val newMedName = updateMedNameEditText.text.toString()
            if (selectedItemPosition != -1 && newMedName.isNotEmpty()) {
                updateMedicine(selectedItemPosition, newMedName)
                finish()
            }
        }
    }

    private fun getMedicine(position: Int): String {
        val file = File(filesDir, "medicines.txt")
        var medName = ""

        BufferedReader(FileReader(file)).useLines { lines ->
            lines.forEachIndexed { index, line ->
                if (index == position) {
                    medName = line
                }
            }
        }

        return medName
    }

    private fun updateMedicine(position: Int, newMedName: String) {
        val file = File(filesDir, "medicines.txt")
        val updatedList = mutableListOf<String>()

        BufferedReader(FileReader(file)).useLines { lines ->
            lines.forEachIndexed { index, line ->
                if (index == position) {
                    updatedList.add(newMedName)
                } else {
                    updatedList.add(line)
                }
            }
        }

        FileWriter(file).use { writer ->
            updatedList.forEach { writer.write("$it\n") }
        }
    }
}
