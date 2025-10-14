fun main() {
    println("Calculadora de costo de envío express")

    // Pedimos la distancia
    print("Ingrese la distancia en km: ")
    val distancia = readLine()?.toIntOrNull() ?: run {
        println("Entrada inválida. Debe ser un número.")
        return
    }

    // Preguntamos si llueve
    print("¿Está lloviendo? (sí/no): ")
    val llueve = readLine()?.lowercase() ?: "no"

    // Determinamos el costo base
    val costoBase = when {
        distancia <= 5 -> 2.5
        distancia in 6..15 -> 5.0
        else -> 8.0
    }

    // Sumamos el costo adicional si llueve
    val costoTotal = if (llueve == "sí") costoBase + 1.5 else costoBase

    // Mostramos el resultado
    println("Costo total: $$costoTotal")
}
