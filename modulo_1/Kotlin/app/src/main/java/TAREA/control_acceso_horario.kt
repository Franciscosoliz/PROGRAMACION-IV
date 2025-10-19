package com.example.basics

fun main() {
    println("=== Control de acceso por horario ===")
    print("Ingrese la hora actual (0–23): ")
    val hora = readln().toIntOrNull()
    if (hora == null || hora !in 0..23) {
        println("Hora inválida. Debe estar entre 0 y 23.")
        return
    }

    print("Ingrese su rol (admin, invitado, empleado): ")
    val rol = readln().lowercase()
    val acceso = when (rol) {
        "admin" -> "Permitido"
        "empleado" -> if (hora in 6..20) "Permitido" else "Denegado"
        "invitado" -> if (hora in 9..17) "Permitido" else "Denegado"
        else -> "Rol no reconocido"
    }

    println("Acceso: $acceso")
}
