package com.example.examen_grsw1_aero

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.io.File
import java.io.FileWriter

class CreateActivity : AppCompatActivity() {

    private lateinit var createMedNameEditText: EditText
    private lateinit var createButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)

        initializeViews()

        createButton.setOnClickListener {
            val newMedName = createMedNameEditText.text.toString()
            if (newMedName.isNotEmpty()) {
                createMedicine(newMedName)
                finish()
            }
        }
    }

    private fun initializeViews() {
        createMedNameEditText = findViewById(R.id.createMedNameEditText)
        createButton = findViewById(R.id.createButton)
    }

    private fun createMedicine(newMedName: String) {
        val file = File(filesDir, "medicines.txt")

        FileWriter(file, true).use { writer ->
            writer.write("$newMedName\n")
        }
    }
}

