package com.example.b2023_gr1sw_vaes

class BBaseDatosMemoria {
    // EMPEZAR EL COMPANION OBJECT
    companion object {
        val arregloBEntrenador = arrayListOf<BEntrenador>()
        init {
            arregloBEntrenador
                .add(
                    BEntrenador(1, "Alex", "a@a.com")
                )
            arregloBEntrenador
                .add(
                    BEntrenador(2,"Vicente", "b@b.com")
                )
            arregloBEntrenador
                .add(
                    BEntrenador(3, "Carolina", "c@c.com")
                )
        }
    }
}