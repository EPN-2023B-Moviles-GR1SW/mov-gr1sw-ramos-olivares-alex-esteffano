package com.example.proyectoii

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Mostrar un mensaje de bienvenida
        val textViewWelcome = findViewById<TextView>(R.id.textView2)
        textViewWelcome.text = "Bienvenido, ${intent.getStringExtra("username")}"
    }
}
