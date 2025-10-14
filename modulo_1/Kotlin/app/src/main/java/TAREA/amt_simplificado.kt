package com.example.basics

fun main() {
    println("=== ATM Simplificado ===")

    print("Ingrese su saldo inicial: ")
    var saldo = readln().toDouble()

    var opcion: Int

    do {
        println("\nMenú de opciones:")
        println("1) Depositar")
        println("2) Retirar")
        println("3) Salir")
        print("Seleccione una opción: ")
        opcion = readln().toInt()

        when (opcion) {
            1 -> {
                print("Ingrese el monto a depositar: ")
                val deposito = readln().toDouble()
                saldo += deposito
                println("Depósito realizado. Saldo actual: $saldo")
            }

            2 -> {
                print("Ingrese el monto a retirar: ")
                val retiro = readln().toDouble()
                if (retiro <= saldo) {
                    saldo -= retiro
                    println("Retiro exitoso. Saldo actual: $saldo")
                } else {
                    println("Fondos insuficientes. No puede dejar saldo negativo.")
                }
            }

            3 -> println("Sesión terminada.")
            else -> println("Opción no válida. Intente nuevamente.")
        }
    } while (opcion != 3)
}
