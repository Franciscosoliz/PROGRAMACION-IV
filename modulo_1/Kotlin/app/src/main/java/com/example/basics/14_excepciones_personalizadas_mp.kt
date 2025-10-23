package com.example.basics

// Excepciones personalizadas
class HerramientaInsuficienteException(message: String) : Exception(message)
class ReparacionPeligrosaException(message: String) : Exception(message)

fun realizarReparacion(nivelExperiencia: Int, nivelDificultad: Int): String {
    return try {
        when {
            nivelExperiencia < 30 -> throw HerramientaInsuficienteException("nivel de experiencia muy bajo: $nivelExperiencia")
            nivelExperiencia < 80 -> throw ReparacionPeligrosaException("reparación extremadamente complicada")
            else -> "reparación completada con éxito"
        }
    } catch (e: HerramientaInsuficienteException) {
        "Error: ${e.message}. Se requiere más práctica y mejores herramientas."
    } catch (e: ReparacionPeligrosaException) {
        "Error: ${e.message}. Nivel de dificultad: $nivelDificultad. Solicitar apoyo del jefe de taller."
    } catch (e: Exception) {
        "Error inesperado: ${e.message}"
    } finally {
        println("Reporte de reparación enviado al sistema del taller.")
    }
}

fun main() {
    println(realizarReparacion(nivelExperiencia = 20, nivelDificultad = 60))
    println(realizarReparacion(nivelExperiencia = 100, nivelDificultad = 60))
}
