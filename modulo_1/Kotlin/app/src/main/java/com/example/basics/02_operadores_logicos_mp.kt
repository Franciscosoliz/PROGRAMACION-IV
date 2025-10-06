package com.example.basics

fun main(){
    println("¡OPERADORES LÓGICOS - TALLER MECÁNICO!")

    val nivelAceite: Int = 80
    val motorRevisado: Boolean = true
    val nivelFrenos: Int = 7

    val estaListo = nivelAceite >= 70 && motorRevisado && nivelFrenos > 5
    val necesitaRevision = !motorRevisado || nivelFrenos < 3

    println("¿El vehículo está listo?: ${estaListo}")
    println("¿Necesita revisión?: ${necesitaRevision}")
}
