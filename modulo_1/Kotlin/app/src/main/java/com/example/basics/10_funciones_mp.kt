package com.example.tallermecanico

fun saludarTaller() {
    println("Bienvenido al sistema del Taller El Turbo")
}

// Función con parámetros y retorno
fun calcularCostoReparacion(horas: Int, tarifaPorHora: Int): Int {
    return horas * tarifaPorHora
}

// Función con expresión simple (single expression function)
fun calcularDescuento(total: Int) = total * 0.10

// Función con retorno múltiple (usando Pair)
fun diagnosticoVehiculo(problemas: Int, piezasDañadas: Int): Pair<Int, Int> {
    val tiempoEstimado = problemas * 2
    val costoEstimado = piezasDañadas * 150
    return Pair(tiempoEstimado, costoEstimado)
}

fun main() {
    println("=== FUNCIONES DEL TALLER MECÁNICO ===\n")

    // Llamada a función simple
    saludarTaller()

    // Función con parámetros
    val total = calcularCostoReparacion(horas = 5, tarifaPorHora = 25)
    println("Costo total de reparación: $${total}")

    // Función con expresión simple
    val descuento = calcularDescuento(total)
    println("Descuento aplicado: $${descuento}")

    // Función con retorno múltiple
    val (tiempo, costo) = diagnosticoVehiculo(problemas = 3, piezasDañadas = 4)
    println("Tiempo estimado: ${tiempo}h | Costo de piezas: $${costo}")

    // Funciones Lambda
    println("\n--- FUNCIONES LAMBDA ---")

    val calcularIVA = { monto: Int -> monto * 0.15 }
    val mensajeEntrega = { cliente: String -> "Estimado $cliente, su vehículo está listo para entrega." }

    println("IVA sobre el total: $${calcularIVA(total)}")
    println(mensajeEntrega("Luis Pérez"))
}
