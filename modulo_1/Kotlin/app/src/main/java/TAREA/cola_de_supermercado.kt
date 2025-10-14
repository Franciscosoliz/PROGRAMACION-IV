package com.example.basics

fun main() {
    println("=== Cola de supermercado ===")

    var totalDia = 0.0           // Acumulador de ventas del día
    var cantidadClientes = 0     // Contador de clientes

    while (true) {
        print("Ingrese 'nuevo' para un nuevo cliente o 'fin' para terminar: ")
        val opcion = readln().lowercase()

        if (opcion == "fin") {
            break
        }

        if (opcion == "nuevo") {
            // Pedir total de compra
            print("Ingrese el total de la compra del cliente: ")
            val totalCompra = readln().toDoubleOrNull()
            if (totalCompra == null || totalCompra < 0) {
                println("Monto inválido.")
                continue
            }

            // Pedir cantidad de ítems
            print("Ingrese la cantidad de ítems del cliente: ")
            val items = readln().toIntOrNull()
            if (items == null || items <= 0) {
                println("Cantidad inválida.")
                continue
            }

            var totalFinal = totalCompra

            // Aplicar descuento si corresponde
            if (totalCompra > 100) {
                val descuento = totalCompra * 0.05
                totalFinal -= descuento
                println("Descuento aplicado del 5%. Nuevo total: $$totalFinal")
            }

            // Mensaje por cantidad de ítems
            if (items > 10) {
                println("Caja rápida no disponible.")
            }

            // Acumular totales
            totalDia += totalFinal
            cantidadClientes++

            println("Cliente atendido correctamente.\n")
        } else {
            println("Opción no válida. Escriba 'nuevo' o 'fin'.")
        }
    }

    // Mostrar resumen final
    println("=== Resumen del día ===")
    println("Clientes atendidos: $cantidadClientes")
    println("Total recaudado: $$totalDia")
    println("¡Fin del turno de caja!")
}
