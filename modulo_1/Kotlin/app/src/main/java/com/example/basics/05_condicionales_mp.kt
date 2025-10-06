package com.example.basics

fun main() {
    println("¡ESTRUCTURAS DE CONTROL - TALLER MECÁNICO!")
    println("¡CONDICIONALES!")

    val tiempoReparacion1 = 18
    val tiempoReparacion2 = 15

    if (tiempoReparacion1 > tiempoReparacion2) {
        println("El trabajo más largo dura $tiempoReparacion1 horas")
    } else {
        println("El trabajo más largo dura $tiempoReparacion2 horas")
    }

    println("Nivel según experiencia del mecánico")
    var experiencia: Int = 10

    if (experiencia > 10) {
        println("Maestro Mecánico")
    } else if (experiencia > 5) {
        println("Mecánico Calificado")
    } else {
        println("Aprendiz")
    }
}
