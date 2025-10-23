package com.example.basics

//El usuario ingresa su promedio y si trabaja (si o no)
// Promedio >= 90 y No trabaja -> Beca completa
// Promedio >= 90 trabaja -> Beca parcial
// Promedio < 90 -> Sin beca

fun main() {
    println("¡ESTRUCTURAS DE CONTROL - BECA UNIVERSITARIA!")
    println("¡CONDICIONALES!")

    println("Ingrese su promedio (ejemplo: 90):")
    val promedio = readLine()!!.toDouble()

    println("¿Trabaja? (si / no):")
    val trabaja = readLine()!!.lowercase()

    println("Resultado de beca:")

    if (promedio >= 90 && trabaja == "no") {
        println("Beca completa")
    } else if (promedio >= 90 && trabaja == "si") {
        println("Beca parcial")
    } else {
        println("Sin beca")
    }
}
