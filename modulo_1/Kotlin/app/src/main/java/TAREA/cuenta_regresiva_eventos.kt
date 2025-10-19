package com.example.basics

fun main() {
    println("=== Cuenta regresiva con eventos ===")

    for (segundo in 30 downTo 0) {
        when (segundo) {
            20 -> println("$segundo → Chequeo de sistemas")
            10 -> println("$segundo → Últimos ajustes")
            0 -> println("Despegue")
            else -> println(segundo)
        }
    }
}
