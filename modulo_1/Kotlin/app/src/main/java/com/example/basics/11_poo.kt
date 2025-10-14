package com.example.basics

data class Jedi(
    val nombre: String,
    val edad: Int,
    val nivelFuerza: Int,
    val maestro: String?=null,
) {
    val rango: String
        get() = when {
            nivelFuerza >= 90 -> "maestro"
            nivelFuerza >= 70 -> "caballero"
            nivelFuerza >= 50 -> "padawan"
            else -> {
                "Iniciado"
            }
        }

    fun puedeEnseniar(): Boolean = nivelFuerza >= 70
    fun entrenar(): Boolean = edad <= 5
    }
fun main(){
    val luke = Jedi(
        nombre = "Anakin Skywalker",
        edad = 25,
        nivelFuerza = 75,
        maestro = "Obiwan Kenobi")
    println(luke)
    //descentralizacion de un objeto
    val(nombre, edad, nivelFuerza) = luke
    println("nombre del Jedi ${nombre}, edad: ${edad}, nivel de fuerza: ${nivelFuerza}")
    //copiar objetos
    val ashoka = luke.copy(nombre= "ashoka", nivelFuerza=80)
    println(ashoka)
    //propiedades calculada
    println("rango de ashoka ${ashoka.rango}")
    println("Ashoka puede enseniar ${ashoka.puedeEnseniar()}")

}
