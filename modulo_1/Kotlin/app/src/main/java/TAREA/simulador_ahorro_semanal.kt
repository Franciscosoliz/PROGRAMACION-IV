package com.example.basics

fun main() {
    println("=== Simulador de ahorro semanal ===")
    print("Ingrese la meta de ahorro: ")
    val meta = readln().toIntOrNull()
    if (meta == null || meta <= 0) {
        println("Meta inválida. Debe ser un número positivo.")
        return
    }

    print("Ingrese el ahorro actual: ")
    var ahorro = readln().toIntOrNull()
    if (ahorro == null || ahorro < 0) {
        println("Ahorro inicial inválido. Debe ser un número positivo.")
        return
    }

    var semana = 1
    var deposito = 5

    while (ahorro < meta) {
        println("Semana $semana: deposito $$deposito | ahorro total antes del depósito: $$ahorro")
        ahorro += deposito
        println("Ahorro después del depósito: $$ahorro")
        println("-----------------------------------")
        deposito += 10
        semana++
    }

    println("Meta alcanzada! Ahorro total: $$ahorro en $semana semanas.")
}
