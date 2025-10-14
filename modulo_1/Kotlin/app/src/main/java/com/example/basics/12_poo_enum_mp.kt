package com.example.tallermecanico

enum class TipoHerramienta(val color: String, val potencia: Int) {
    LLAVE_INGLES("plateado", 85) {
        override fun descripcion() = "Herramienta clásica para ajustar tuercas y pernos."
    },
    DESTORNILLADOR("amarillo", 75) {
        override fun descripcion() = "Usado para apretar o aflojar tornillos de precisión."
    },
    TALADRO("rojo", 95) {
        override fun descripcion() = "Herramienta eléctrica para perforar superficies metálicas."
    },
    GATO_HIDRAULICO("azul", 90) {
        override fun descripcion() = "Dispositivo para elevar vehículos durante reparaciones."
    };

    abstract fun descripcion(): String

    companion object {
        fun porColor(color: String) = values().find { it.color == color }
    }
}

// Clase que representa una herramienta en uso
class Herramienta(val tipo: TipoHerramienta, val operador: String) {
    fun usar() = "${operador} usa la ${tipo.name.lowercase()} (${tipo.color}) con potencia ${tipo.potencia}."
    fun info() = "${tipo.descripcion()} - Potencia: ${tipo.potencia}"
}

fun main() {
    println("=== SISTEMA DE HERRAMIENTAS DEL TALLER ===")

    val herramientaPedro = Herramienta(TipoHerramienta.TALADRO, operador = "Pedro")
    println("\n$herramientaPedro")
    println(herramientaPedro.usar())
    println(herramientaPedro.info())

    val herramientaAna = Herramienta(TipoHerramienta.LLAVE_INGLES, operador = "Ana")
    println("\n$herramientaAna")
    println(herramientaAna.usar())
    println(herramientaAna.info())

    // Ejemplo del método del companion object
    val herramientaBuscada = TipoHerramienta.porColor("azul")
    println("\nHerramienta buscada por color 'azul': ${herramientaBuscada?.name}")
}
