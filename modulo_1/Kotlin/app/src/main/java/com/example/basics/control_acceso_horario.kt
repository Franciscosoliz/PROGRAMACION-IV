fun main() {
    println("Control de acceso por horario")

    // Pedimos la hora
    print("Ingrese la hora (0-23): ")
    val hora = readLine()?.toIntOrNull() ?: run {
        println("Entrada inválida. Debe ser un número entre 0 y 23.")
        return
    }

    if (hora !in 0..23) {
        println("Hora inválida. Debe estar entre 0 y 23.")
        return
    }

    // Pedimos el rol
    print("Ingrese su rol (admin, invitado, empleado): ")
    val rol = readLine()?.lowercase() ?: ""

    // Evaluamos acceso
    val acceso = when (rol) {
        "admin" -> "Permitido"
        "empleado" -> if (hora in 6..20) "Permitido" else "Denegado"
        "invitado" -> if (hora in 9..17) "Permitido" else "Denegado"
        else -> "Rol desconocido"
    }

    println("Acceso: $acceso")
}
