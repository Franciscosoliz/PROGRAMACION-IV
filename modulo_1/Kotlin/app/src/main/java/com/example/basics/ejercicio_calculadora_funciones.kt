package com.example.basic


fun sumar(a: Int, b: Int): Int {
    return a + b
}

fun main() {
    println("INGRESE EL PRIMER NUMERO")
    val value1: Int = readLine()?.toIntOrNull() ?: 0

    println("Ingrese segundo valor:")
    val value2: Int = readLine()?.toIntOrNull() ?: 0

    println("Ingrese la operación (" +
            "1 SUMA \n" +
            "2 RESTA \n" +
            "3 MULTIPLICACION \n" +
            "4 DIVISION): ")
    val operacion: String = readLine() ?: ""

    when (operacion) {
        "1" -> println("Suma: ${sumar(value1, value2)}")
        "2" -> println("Resta: ${value1 - value2}")
        "3" -> println("Multiplicación: ${value1 * value2}")
        "4" -> {
            if (value2 != 0) {
                println("División: ${value1 / value2}")
            } else {
                println("No se puede dividir por cero")
            }
        }
        else -> println("Operación no válida")
    }
}