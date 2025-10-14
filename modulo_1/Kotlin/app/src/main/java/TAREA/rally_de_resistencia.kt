package com.example.basics

import kotlin.random.Random

fun main() {
    println("=== Rally de Resistencia ===")

    print("Ingrese el número total de etapas: ")
    val etapas = readln().toInt()

    var energia = 100

    for (etapa in 1..etapas) {
        val terreno = Random.nextInt(1, 4) // genera 1, 2 o 3

        when (terreno) {
            1 -> {
                energia -= 5
                println("Etapa $etapa: Terreno de asfalto (-5 energía). Energía actual: $energia")
            }
            2 -> {
                energia -= 10
                println("Etapa $etapa: Terreno de tierra (-10 energía). Energía actual: $energia")
            }
            3 -> {
                energia -= 15
                println("Etapa $etapa: Terreno de barro (-15 energía). Energía actual: $energia")
            }
        }

        if (energia <= 0) {
            println("Abandona en la etapa $etapa. Energía agotada.")
            return
        }
    }

    println("Rally completado con energía final de $energia.")
}
