package com.example.deber3_ramos_alex

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Recarga : AppCompatActivity() {

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recarga)

        // Permitir al usuario ingresar el monto de la recarga
        val editTextAmount = findViewById<EditText>(R.id.button)

        // Realizar la recarga de saldo
        val paymentManager = PaymentManager()
        val rechargeResult = paymentManager.recharge(editTextAmount.text.toString())

    }
}