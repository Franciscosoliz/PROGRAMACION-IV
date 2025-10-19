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

    while (i < nombre.length || j < apellido.length) {
        repeat(2) {
            if (i < nombre.length) {
                username += nombre[i]
                i++
            }
        }
        repeat(2) {
            if (j < apellido.length) {
                username += apellido[j]
                j++
            }
        }
    }
    var num = 1
    while (username.length < 6) {
        username += num.toString()
        num++
    }

    println("Nombre de usuario generado: $username")
}
