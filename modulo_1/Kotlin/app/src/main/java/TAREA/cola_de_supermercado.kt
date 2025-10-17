package com.example.basics

fun main() {
    println("=== Cola de supermercado ===")

    var totalDia = 0.0
    var cantidadClientes = 0

    while (true) {
        print("Ingrese 'nuevo' para un nuevo cliente o 'fin' para terminar: ")
        val opcion = readln().lowercase()

        if (opcion == "fin") {
            break
        }

        if (opcion == "nuevo") {
            print("Ingrese el total de la compra del cliente: ")
            val totalCompra = readln().toDoubleOrNull()
            if (totalCompra == null || totalCompra < 0) {
                println("Monto inválido.")
                continue
            }

            print("Ingrese la cantidad de ítems del cliente: ")
            val items = readln().toIntOrNull()
            if (items == null || items <= 0) {
                println("Cantidad inválida.")
                continue
            }

            var totalFinal = totalCompra
            if (totalCompra > 100) {
                val descuento = totalCompra * 0.05
                totalFinal -= descuento
                println("Descuento aplicado del 5%. Nuevo total: $$totalFinal")
            }

            if (items > 10) {
                println("Caja rápida no disponible.")
            }

            totalDia += totalFinal
            cantidadClientes++

            println("Cliente atendido correctamente.\n")
        } else {
            println("Opción no válida. Escriba 'nuevo' o 'fin'.")
        }
    }

    println("=== Resumen del día ===")
    println("Clientes atendidos: $cantidadClientes")
    println("Total recaudado: $$totalDia")
    println("¡Fin del turno de caja!")
}
