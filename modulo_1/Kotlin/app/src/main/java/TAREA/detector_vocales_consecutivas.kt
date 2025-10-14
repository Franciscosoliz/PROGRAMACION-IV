package com.example.basics

fun main() {
    println("=== Detector de vocales consecutivas ===")

    // Pedir texto al usuario
    print("Ingrese un texto: ")
    val texto = readln().lowercase()

    // Definir conjunto de vocales
    val vocales = "aeiou"

    var contador = 0

    // Recorrer el texto comparando pares de caracteres consecutivos
    for (i in 0 until texto.length - 1) {
        val actual = texto[i]
        val siguiente = texto[i + 1]

        // Si ambos son vocales, contar
        if (actual in vocales && siguiente in vocales) {
            contador++
        }
    }

    // Mostrar el resultado final
    println("Total de vocales consecutivas encontradas: $contador")
}
