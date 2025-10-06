package com.example.basics

fun main(){
    println("¡OPERADORES DE IGUALDAD - TALLER MECÁNICO!")

    val mecanico1: String = "Carlos"
    val mecanico2: String = "Carlos"
    val mecanico3: String = String("Carlos".toCharArray())

    println("Igualdad estructural (mismo nombre)")
    println(mecanico1 == mecanico2)
    println(mecanico1 == mecanico3)

    println("Igualdad referencial (misma instancia en memoria)")
    println(mecanico1 === mecanico2)
    println(mecanico1 === mecanico3)
}
