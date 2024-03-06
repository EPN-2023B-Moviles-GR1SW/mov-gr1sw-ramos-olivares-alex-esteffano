package com.example.deber3_ramos_alex;

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.deber3_ramos_alex.R
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar el menú
        val menu = findViewById<NavigationView>(R.id.bottomNavigationView)
        menu.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.imageView2 -> {
                // Abrir la actividad para generar código QR
                val intent = Intent(this, QRGeneratorActivity::class.java)
                startActivity(intent)
            }
            R.id.button -> {
                // Abrir la actividad para revisar historial de pagos
                val intent = Intent(this, PaymentHistoryAdapter::class.java)
                startActivity(intent)
            }
            R.id.button -> {
                // Abrir la actividad para realizar recargas
                val intent = Intent(this, Recarga::class.java)
                startActivity(intent)
            }
            R.id.button -> {
                // Abrir la actividad para ver el perfil de usuario
                val intent = Intent(this, Perfil::class.java)
                startActivity(intent)
            }
        }
        return true
    }
}
