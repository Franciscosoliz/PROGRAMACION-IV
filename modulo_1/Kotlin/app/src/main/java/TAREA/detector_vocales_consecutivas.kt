package com.example.basics

fun main() {
    println("=== Detector de vocales consecutivas ===")
    print("Ingrese un texto: ")
    val texto = readln().lowercase()
    val vocales = "aeiou"
    var contador = 0

    for (i in 0 until texto.length - 1) {
        val actual = texto[i]
        val siguiente = texto[i + 1]

        // Si ambos son vocales, contar
        if (actual in vocales && siguiente in vocales) {
            contador++
        }
    }
    
    println("Total de vocales consecutivas encontradas: $contador")
}
