package com.example.examen_grsw1_aero

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class ECrudEntrenador : AppCompatActivity() {
        @SuppressLint("SuspiciousIndentation", "CutPasteId")
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_ecrud_entrenador)
            // Logica Buscar Entrenador
            val botonBuscarBDD = findViewById<Button>(R.id.btn_buscar_bdd)
            botonBuscarBDD
                .setOnClickListener {
                    // Obtener componentes visuales

                    val nombre = findViewById<EditText>(R.id.input_nombre)

                    // Busqueda en la BDD Sqlite
                    val entrenador = EBaseDeDatos.tablaEntrenador!!
                        .consultarEntrenadorPorID(
                            nombre.text.toString().toInt()
                        )
                        mostrarSnackbar("Usu. no encontrado")
                    nombre.setText(entrenador.nombre)

                    mostrarSnackbar("Usu. encontrado")
                }

            val botonCrearBDD = findViewById<Button>(R.id.btn_crear_bdd)
            botonCrearBDD
                .setOnClickListener {
                    findViewById<EditText>(R.id.input_nombre)

                }
            val botonActualizarBDD = findViewById<Button>(R.id.btn_actualizar_bdd)
            botonActualizarBDD
                .setOnClickListener {
                    findViewById<EditText>(R.id.input_nombre)
                }

            val botonEliminarBDD = findViewById<Button>(R.id.btn_eliminar_bdd)
            botonEliminarBDD.setOnClickListener {
                val id = findViewById<EditText>(R.id.input_nombre)
                val respuesta = EBaseDeDatos.tablaEntrenador!!.eliminarEntrenadorFormulario(
                    id.text.toString().toInt()
                )
                if (respuesta) mostrarSnackbar("Usu. Eliminado")
            }
        }// Fin OnCreate
        private fun mostrarSnackbar(texto: String) {
            Snackbar
                .make(
                    findViewById(R.id.sqlite), // view
                    texto, // texto
                    Snackbar.LENGTH_LONG // tiempo
                )
                .show()
        }
    }
