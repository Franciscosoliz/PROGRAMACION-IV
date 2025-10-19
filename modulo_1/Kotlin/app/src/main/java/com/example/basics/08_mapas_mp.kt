package com.example.tallermecanico

fun main() {
    println("\n=== REGISTRO DE MECÁNICOS Y VEHÍCULOS ===")

    // Mapa: Habilidad de los mecánicos
    val habilidadMecanicos = mapOf(
        "Carlos" to 85,
        "Pedro" to 90,
        "Ana" to 95,
        "Luis" to 88
    )
    println("Niveles de habilidad de los mecánicos: $habilidadMecanicos")

    // Mapa mutable: Reparaciones realizadas por cada mecánico
    println("\n--- Reparaciones Completadas ---")
    val reparacionesCompletadas = mutableMapOf<String, Int>()
    reparacionesCompletadas["Carlos"] = 15
    reparacionesCompletadas["Ana"] = 18
    reparacionesCompletadas.put("Pedro", 22)
    reparacionesCompletadas.put("Luis", 10)

    println("Reparaciones registradas: $reparacionesCompletadas")

    // Mostrar detalles por mecánico
    println("\n--- Detalle de Mecánicos ---")
    for ((mecanico, habilidad) in habilidadMecanicos) {
        println("$mecanico tiene un nivel de habilidad de $habilidad puntos.")
    }

    // Conjuntos: autos y sus estados
    println("\n--- Listado de Vehículos ---")
    val autosEnTaller = setOf("Toyota Hilux", "Nissan Sentra", "Kia Sportage", "Chevrolet Aveo")
    println("Autos actualmente en el taller: $autosEnTaller")

    val autosConProblemasGraves = setOf("Chevrolet Aveo", "Ford Ranger", "Toyota Hilux")
    println("Autos con problemas graves: $autosConProblemasGraves")

    // Operaciones de conjuntos
    println("\n--- Análisis de Vehículos ---")
    val autosCriticos = autosConProblemasGraves intersect autosEnTaller
    val todosLosAutos = autosConProblemasGraves union autosEnTaller
    val autosListos = autosEnTaller - autosConProblemasGraves

    println("Autos en el taller y con problemas graves: $autosCriticos")
    println("Todos los autos registrados: $todosLosAutos")
    println("Autos listos o sin problemas graves: $autosListos")

    // Extra: calcular el mecánico con más reparaciones
    println("\n--- Mecánico Destacado ---")
    val mecanicoTop = reparacionesCompletadas.maxByOrNull { it.value }
    println("El mecánico con más reparaciones es ${mecanicoTop?.key} con ${mecanicoTop?.value} reparaciones.")
}
