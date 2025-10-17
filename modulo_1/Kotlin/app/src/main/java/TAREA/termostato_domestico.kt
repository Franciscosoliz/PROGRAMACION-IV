package com.example.basics

fun main() {
    println("=== Termostato doméstico ===")
    print("Ingrese la temperatura actual en °C: ")
    val temperatura = readln().toIntOrNull()
    if (temperatura == null) {
        println("Entrada inválida. Debe ser un número.")
        return
    }

    print("Ingrese su preferencia (frío, templado, caliente): ")
    val preferencia = readln().lowercase()

    when {
        preferencia == "frío" && temperatura > 22 -> println("Encender aire")
        preferencia == "caliente" && temperatura < 18 -> println("Encender calefacción")
        preferencia == "templado" && temperatura in 18..22 -> println("En confort")
        else -> println("Ventilar")
    }
}
