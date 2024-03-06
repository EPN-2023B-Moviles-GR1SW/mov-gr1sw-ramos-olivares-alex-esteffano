package com.example.deber3_ramos_alex

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.qrcode.encoder.QRCode


class QRGeneratorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qr)

        // Generar el código QR
        val qrGenerator = QRGenerator()
        val qrCode = qrGenerator.generateQRCode("Fecha de vencimiento")

        // Mostrar la imagen del código QR
        val imageView = findViewById<ImageView>(R.id.imageView2)
        imageView.setImageBitmap(qrCode)
    }
}