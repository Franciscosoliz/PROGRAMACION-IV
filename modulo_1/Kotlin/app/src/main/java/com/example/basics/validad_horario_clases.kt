package com.example.basics

//el alumno ingresa una hora 0-23
//si esta entre 7y11 "clase en la mañana"
//si esta entre 14 y 19 "clase de la tarde"
//otro caso "horario lectivo

fun main() {
    println("¡ESTRUCTURAS DE CONTROL - HORARIO DE CLASES!")
    println("¡CONDICIONALES!")

    println("Ingrese la hora (0 - 23):")
    val hora = readLine()!!.toInt()

    println("Resultado:")

    if (hora in 7..11) {
        println("Clase en la mañana")
    } else if (hora in 14..19) {
        println("Clase en la tarde")
    } else {
        println("Fuera del horario lectivo")
    }
}
