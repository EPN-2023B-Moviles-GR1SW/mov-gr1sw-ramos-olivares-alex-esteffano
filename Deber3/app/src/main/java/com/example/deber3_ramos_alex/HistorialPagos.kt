package com.example.deber3_ramos_alex

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class HistorialPagos : AppCompatActivity() {

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viajes)

        // Obtener el historial de pagos del servidor
        val paymentManager = PaymentManager()
        val payments = paymentManager.getPaymentHistory()

        // Mostrar la lista de pagos
        val listView = findViewById<ListView>(R.id.button)
    }
}