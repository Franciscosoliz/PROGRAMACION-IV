package com.example.basics

fun main() {
    println("=== Costo de envío express ===")

    // Pedir la distancia en km
    print("Ingrese la distancia en km: ")
    val distancia = readln().toIntOrNull()
    if (distancia == null || distancia < 0) {
        println("Entrada inválida. Debe ingresar un número positivo.")
        return
    }

    // Preguntar si está lloviendo
    print("¿Está lloviendo? (sí/no): ")
    val llueve = readln().lowercase()

    // Determinar costo base según la distancia
    val costoBase = when {
        distancia <= 5 -> 2.5
        distancia in 6..15 -> 5.0
        distancia > 15 -> 8.0
        else -> 0.0
    }

    // Si llueve, agregar 1.5
    val costoTotal = if (llueve == "sí") costoBase + 1.5 else costoBase

    // Mostrar el resultado
    println("Costo total: $$costoTotal")
}
