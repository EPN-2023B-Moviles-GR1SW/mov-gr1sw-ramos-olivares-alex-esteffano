package com.example.examen_grsw1_aero

import com.google.firebase.firestore.FirebaseFirestore

private val id: String
    get() = Unit.toString()
private val nombre: Any
    get() {
        TODO("Not yet implemented")
    }

class FireStoreMedicina {
    private val db = FirebaseFirestore.getInstance()
    private val medicinasCollection = db.collection("Medicina")

    fun crearMedicina(nuevaMedicina: String){
        val datosMedicina = hashMapOf(
            "nombre" to nombre,

        )
    }

    fun eliminarSistema(){

        medicinasCollection.document(id)
            .delete()
            .addOnSuccessListener {
                DeleteActivity.listaMedicinas.removeAt(DeleteActivity.listaMedicinas)
            }
            .addOnFailureListener{  }
    }
    fun editarSistema(nuevoSistema: EBaseDeDatos){
        val nuevaMedicina = null
        val datosSistema = hashMapOf(
            "nombre" to nombre
        )
        medicinasCollection.document(id)
            .set(datosSistema)
            .addOnSuccessListener {  }
            .addOnFailureListener {  }
    }
}

private fun Any.removeAt(listaMedicinas: Any) {

}

private operator fun Any.get(medicinas: Any): Any {
    TODO("Not yet implemented")
}
