package com.example.basics

import android.graphics.Color

enum class TipoSable(val color: String, val poder: Int) {
    AZUL("verde",  85){
        override fun descripcion()= "sable tradicional de los Jedi"
    },
    VERDE(  "verde",  90){
        override fun descripcion()="sable de los jedi consulares"
    },
    ROJO( "rojo",  95){
       override fun descripcion()="sable de los sith"
    },
    MORADO( "morado", 95){
        override fun descripcion()="sable equilibra luz y oscuridad"
    };
    abstract fun descripcion(): String
    companion object {
        fun porColor(color: String)= values().find {it.color==color}
    }
}
class SableDeLuz(val tipo: TipoSable, val portador: String){
    fun activar() ="!ZZZrum! el sable color ${tipo.color} de ${portador} se enciende"
    fun info()= "${tipo.descripcion()} - tipo poder ${tipo.poder}"
}

fun main(){
    val sableWindoo = SableDeLuz(TipoSable.MORADO, portador = "Wiindoo")
    println(sableWindoo)
    println(sableWindoo.activar())
    println(sableWindoo.info())

    val sableLuke = SableDeLuz(TipoSable.VERDE, portador = "Luke Skywalker")
    println(sableLuke)
    println(sableLuke.activar())
    println(sableLuke.info())
}