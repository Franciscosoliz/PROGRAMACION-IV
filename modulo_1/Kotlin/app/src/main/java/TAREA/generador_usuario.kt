package com.example.basics

fun main() {
    println("=== Generador de Usuario ===")

    print("Ingrese su nombre: ")
    val nombre = readln().lowercase()

    print("Ingrese su apellido: ")
    val apellido = readln().lowercase()

    var username = ""
    var i = 0
    var j = 0

    // Generar username alternando 2 letras del nombre y 2 del apellido
    while (i < nombre.length || j < apellido.length) {
        // Añade 2 letras del nombre si hay disponibles
        repeat(2) {
            if (i < nombre.length) {
                username += nombre[i]
                i++
            }
        }
        // Añade 2 letras del apellido si hay disponibles
        repeat(2) {
            if (j < apellido.length) {
                username += apellido[j]
                j++
            }
        }
    }

    // Si el username tiene menos de 6 caracteres, agregar números consecutivos
    var num = 1
    while (username.length < 6) {
        username += num.toString()
        num++
    }

    println("Nombre de usuario generado: $username")
}
