package com.example.tallermecanico

fun main() {
    println("=== LISTAS DEL TALLER MECÁNICO ===")

    // Lista inmutable de autos en espera
    val autosEnEspera: List<String> = listOf("Toyota Hilux", "Nissan Sentra", "Chevrolet Aveo")
    println("Autos en espera (lista inmutable): $autosEnEspera")

    // Lista mutable de autos en reparación
    val autosEnReparacion: MutableList<String> = mutableListOf("Kia Sportage", "Ford Ranger", "Mazda CX5")
    println("\nAutos en reparación (lista mutable): $autosEnReparacion")

    // Agregar nuevo auto
    autosEnReparacion.add("Hyundai Tucson")
    println("Agregando nuevo auto: $autosEnReparacion")

    // Remover primer auto (ya reparado)
    autosEnReparacion.removeAt(0)
    println("Removiendo el primer auto (ya reparado): $autosEnReparacion")

    // Recorrer lista
    println("\nListado actual de autos en reparación:")
    for (auto in autosEnReparacion) println("- $auto")

    // Operaciones con lista mutable
    println("\n--- Operaciones con Lista de Repuestos ---")

    val repuestos = mutableListOf("Filtro de aceite", "Bujías")
    repuestos.add("Pastillas de freno")
    repuestos += "Aceite de motor"
    repuestos.add(1, "Filtro de aire")

    println("Lista de repuestos actualizada: $repuestos")

    repuestos.remove("Bujías")
    println("Eliminando repuesto 'Bujías': $repuestos")

    repuestos.removeAt(0)
    println("Removiendo el primer repuesto: $repuestos")

    repuestos[0] = "Neumáticos"
    println("Modificando repuesto en posición 0: $repuestos")

    repuestos.clear()
    println("¿La lista de repuestos está vacía?: ${repuestos.isEmpty()}")

    // Búsqueda en listas
    println("\n--- Búsqueda en Lista de Clientes ---")

    val clientes = mutableListOf("Juan", "Luis", "Pedro", "Ana")
    println("find -> ${clientes.find { it.startsWith("L") }}")
    println("firstOrNull -> ${clientes.firstOrNull { it.length == 4 }}")
    println("any -> ${clientes.any { it.contains('J', ignoreCase = true) }}")
    println("none -> ${clientes.none { it == "Carlos" }}")

    // Ordenamiento con listas
    println("\n--- Ordenamiento de Costos de Reparación ---")

    val costos = mutableListOf(250.0, 100.0, 300.0, 150.0, 100.0)
    println("Costos ordenados ascendente: ${costos.sorted()}")
    println("Costos ordenados descendente: ${costos.sortedDescending()}")
    println("Costos únicos (sin repetidos): ${costos.distinct()}")
}
