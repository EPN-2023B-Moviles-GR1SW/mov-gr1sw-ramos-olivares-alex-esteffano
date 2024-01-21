import java.io.File

data class Medicina(val id: Int, var nombre: String, var dosis: String, var frecuencia: String, var descripcion: String)

class RecordatorioMedicinas(private val archivo: File) {
    private var medicinas: MutableList<Medicina> = mutableListOf()

    init {
        cargarDatos()
    }

    private fun cargarDatos() {
        if (archivo.exists()) {
            archivo.readLines().forEach {
                val partes = it.split(",")
                if (partes.size == 5) {
                    val id = partes[0].toInt()
                    val nombre = partes[1]
                    val dosis = partes[2]
                    val frecuencia = partes[3]
                    val descripcion = partes[4]
                    medicinas.add(Medicina(id, nombre, dosis, frecuencia, descripcion))
                }
            }
        }
    }

    private fun guardarDatos() {
        archivo.printWriter().use { writer ->
            medicinas.forEach {
                writer.println("${it.id},${it.nombre},${it.dosis},${it.frecuencia},${it.descripcion}")
            }
        }
    }

    fun agregarMedicina(medicina: Medicina) {
        val nuevoId = if (medicinas.isEmpty()) 1 else medicinas.maxByOrNull { it.id }!!.id + 1
        val nuevaMedicina = Medicina(nuevoId, medicina.nombre, medicina.dosis, medicina.frecuencia, medicina.descripcion)
        medicinas.add(nuevaMedicina)
        guardarDatos()
    }

    fun obtenerMedicina(id: Int): Medicina? {
        return medicinas.find { it.id == id }
    }

    fun actualizarMedicina(medicina: Medicina) {
        val index = medicinas.indexOfFirst { it.id == medicina.id }
        if (index != -1) {
            medicinas[index] = medicina
            guardarDatos()
        }
    }

    fun eliminarMedicina(id: Int) {
        medicinas.removeIf { it.id == id }
        guardarDatos()
    }

    fun listarMedicinas() {
        if (medicinas.isEmpty()) {
            println("No hay medicinas en el recordatorio.")
        } else {
            medicinas.forEach {
                println("ID: ${it.id}, Nombre: ${it.nombre}, Dosis: ${it.dosis}, Frecuencia: ${it.frecuencia}, Descripción: ${it.descripcion}")
            }
        }
    }
}

fun main() {
    val archivoMedicinas = File("ARCHIVOS")
    val recordatorio = RecordatorioMedicinas(archivoMedicinas)

    while (true) {
        println("\n--- Menú ---")
        println("1. Agregar Medicina")
        println("2. Eliminar Medicina")
        println("3. Listar Medicinas")
        println("4. Salir")

        print("Seleccione una opción: ")
        when (readLine()?.toIntOrNull()) {
            1 -> {
                println("\n--- Agregar Medicina ---")
                print("Nombre: ")
                val nombre = readLine() ?: ""
                print("Dosis: ")
                val dosis = readLine() ?: ""
                print("Frecuencia: ")
                val frecuencia = readLine() ?: ""
                print("Descripción: ")
                val descripcion = readLine() ?: ""

                val nuevaMedicina = Medicina(0, nombre, dosis, frecuencia, descripcion)
                recordatorio.agregarMedicina(nuevaMedicina)
                println("Medicina agregada correctamente.")
            }
            2 -> {
                println("\n--- Eliminar Medicina ---")
                print("Ingrese el ID de la medicina a eliminar: ")
                val idEliminar = readLine()?.toIntOrNull() ?: 0
                recordatorio.eliminarMedicina(idEliminar)
                println("Medicina eliminada correctamente.")
            }
            3 -> {
                println("\n--- Listar Medicinas ---")
                recordatorio.listarMedicinas()
            }
            4 -> {
                println("Saliendo del programa. ¡Gracias por su visita!")
                return
            }
            else -> println("Opción no válida. Por favor, seleccione una opción válida.")
        }
    }
}
