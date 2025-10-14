package com.example.basics

fun main() {
    println("Simulación de batería")
    println("----")

    for (bateria in 100 downTo 0 step 10) {
        when (bateria) {
            100 -> println("Nivel de batería: $bateria% → Batería cargada")
            50 -> println("Nivel de batería: $bateria% → Batería a la mitad")
            10 -> println("Nivel de batería: $bateria% → Conecte el cargador")
            0 -> println("Nivel de batería: $bateria% → Celular apagado")
            else -> println("Nivel de batería: $bateria%")
        }
        Thread.sleep(500) // Pausa para simular el tiempo de descarga
    }

    println("----")
    println("Fin de la simulación")
}
