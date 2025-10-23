package com.example.basics

fun main() {
    println("=== Termostato doméstico ===")

    // Pedimos la temperatura
    print("Ingrese la temperatura actual en °C: ")
    val temperatura = readln().toIntOrNull()
    if (temperatura == null) {
        println("Entrada inválida. Debe ser un número.")
        return
    }

    // Pedimos la preferencia del usuario
    print("Ingrese su preferencia (frío, templado, caliente): ")
    val preferencia = readln().lowercase()

    // Evaluamos las condiciones con when
    when {
        preferencia == "frío" && temperatura > 22 -> println("Encender aire")
        preferencia == "caliente" && temperatura < 18 -> println("Encender calefacción")
        preferencia == "templado" && temperatura in 18..22 -> println("En confort")
        else -> println("Ventilar")
    }
}
