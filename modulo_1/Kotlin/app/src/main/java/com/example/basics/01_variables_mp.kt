package com.example.tallermecanico

fun main() {
    println("=== SISTEMA DEL TALLER MECÁNICO ===")
    val nombreTaller = "Taller El Turbo"
    var mecanico = "Carlos"
    mecanico = "Pedro"
    println("Bienvenido al $nombreTaller. Mecánico asignado: $mecanico")

    //Tipo Variables//
    println("\n--- Tipos de Datos ---")

    println("Tipo Int")
    val autosReparadosHoy: Int = 5
    println("Autos reparados hoy: $autosReparadosHoy")

    println("Tipo Double")
    val costoPromedio: Double = 125.75
    println("Costo promedio de reparación: $costoPromedio USD")

    println("Tipo Float")
    val tiempoPromedio: Float = 3.5f
    println("Tiempo promedio por reparación: $tiempoPromedio horas")

    println("Tipo Long")
    val totalReparaciones: Long = 1_250L
    println("Total de reparaciones en el año: $totalReparaciones")

    println("Tipo String")
    val tipoVehiculo: String = "Camioneta Toyota Hilux"
    println("Tipo de vehículo: $tipoVehiculo")

    println("Tipo Char")
    val calificacion: Char = 'A'
    println("Calificación del servicio: $calificacion")

    println("Tipo Boolean")
    val estaListo: Boolean = true
    println("¿El vehículo está listo para entrega?: $estaListo")

    //Nulo//
    println("\n--- Nulidad ---")
    val nombreCliente: String? = null
    println("Cliente: $nombreCliente")

    val observacion: String? = "Revisión completa"
    println("Observación: ${observacion?.uppercase()}")

    val longitudSegura = nombreCliente?.length ?: 0
    println("Longitud segura del nombre del cliente: $longitudSegura")

    //Interpolacion//
    println("\n--- Interpolación ---")
    val cliente = "Luis"
    val vehiculo = "Nissan Sentra"
    val costo = 230.50
    println("El cliente $cliente trajo su $vehiculo al taller.")
    println("El costo total de reparación será: $${costo}")

    //String//
    println("\n--- Factura Detallada ---")
    val factura = """
        Taller: $nombreTaller
        Cliente: $cliente
        Vehículo: $vehiculo
        Mecánico: $mecanico
        Costo Total: $${costo}
        Estado: ${if (estaListo) "Listo para entrega" else "En reparación"}
        ¡Gracias por confiar en nosotros!
    """.trimIndent()
    println(factura)

    //Conversiones//
    println("\n--- Conversiones ---")
    val textoKilometros: String = "150000"
    val kilometros: Int = textoKilometros.toInt()
    println("Kilometraje del vehículo: $kilometros km")

    val total: Double = 1250.0
    val totalTexto: String = total.toString()
    println("Total (como texto): $totalTexto")
}
