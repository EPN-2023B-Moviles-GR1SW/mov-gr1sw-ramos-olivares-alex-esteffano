package com.example.deber3_ramos_alex

import android.os.Bundle
import android.os.UserManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

private val <E> List<E>.name: CharSequence?
    get() {
        TODO("Not yet implemented")
    }
private val <E> List<E>.email: CharSequence?
    get() {
        TODO("Not yet implemented")
    }


class Perfil : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        // Obtener la información del perfil del usuario del servidor
        val userManager = UserManager()
        val user = userManager.userProfiles

        // Mostrar la información del usuario
        val textViewName = findViewById<TextView>(R.id.button)
        textViewName.text = user.name

        val textViewEmail = findViewById<TextView>(R.id.button3)
        textViewEmail.text = user.email

    }}