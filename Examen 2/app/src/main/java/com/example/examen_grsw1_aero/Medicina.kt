package com.example.examen_grsw1_aero

class Medicina(
    private var nombre: String,
    var frecuencia: String,
    var dosis: String,
) {

    constructor(
        nombre: String
    ) : this(
        nombre,
        "",
        ""
    )

    override fun toString(): String {
        return "$nombre"
    }
}


