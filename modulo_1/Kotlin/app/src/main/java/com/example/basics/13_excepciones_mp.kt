package com.example.basics

fun main() {
    println("=== SISTEMA DE REPARACIONES DEL TALLER ===")

    try {
        val costoRepuesto = 500
        val cantidadRepuestos = 0  // Error: no se puede dividir por 0
        val costoUnitario = costoRepuesto / cantidadRepuestos

        println("Costo por repuesto: $$costoUnitario")
    } catch (e: Exception) {
        println("Error detectado: ${e.message}")
        println("No se puede calcular el costo unitario. Verifique la cantidad de repuestos.")
    } finally {
        println("🧾 Registro de reparación actualizado en el sistema del taller.")
    }
}
