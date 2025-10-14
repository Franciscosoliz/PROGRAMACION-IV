package com.example.tallermecanico

data class Mecanico(
    val nombre: String,
    val edad: Int,
    val nivelHabilidad: Int,
    val jefe: String? = null,
) {
    // Propiedad calculada: rango del mecánico
    val rango: String
        get() = when {
            nivelHabilidad >= 90 -> "Jefe de taller"
            nivelHabilidad >= 70 -> "Mecánico senior"
            nivelHabilidad >= 50 -> "Mecánico junior"
            else -> "Aprendiz"
        }

    // Puede supervisar a otros mecánicos
    fun puedeSupervisar(): Boolean = nivelHabilidad >= 70

    // Puede ser aprendiz si tiene poca edad
    fun esAprendiz(): Boolean = edad <= 20
}

fun main() {
    println("=== REGISTRO DE MECÁNICOS DEL TALLER ===")

    val pedro = Mecanico(
        nombre = "Pedro García",
        edad = 28,
        nivelHabilidad = 75,
        jefe = "Carlos Ramírez"
    )
    println(pedro)

    // Desestructuración del objeto
    val (nombre, edad, nivelHabilidad) = pedro
    println("Nombre del mecánico: $nombre, Edad: $edad, Nivel de habilidad: $nivelHabilidad")

    // Copiar objeto con cambios
    val ana = pedro.copy(nombre = "Ana López", nivelHabilidad = 92)
    println("\nCopia modificada: $ana")

    // Propiedad calculada
    println("Rango de ${ana.nombre}: ${ana.rango}")

    // Funciones personalizadas
    println("${ana.nombre} puede supervisar a otros: ${ana.puedeSupervisar()}")
    println("${ana.nombre} es aprendiz: ${ana.esAprendiz()}")
}
