package com.example.basics

fun main() {
    println("=== Cuenta regresiva con eventos ===")

    // Bucle desde 30 hasta 0 (decrementando)
    for (segundo in 30 downTo 0) {
        // Evaluar casos especiales con when
        when (segundo) {
            20 -> println("$segundo → Chequeo de sistemas")
            10 -> println("$segundo → Últimos ajustes")
            0 -> println("¡Despegue! 🚀")
            else -> println(segundo)
        }
    }
}
