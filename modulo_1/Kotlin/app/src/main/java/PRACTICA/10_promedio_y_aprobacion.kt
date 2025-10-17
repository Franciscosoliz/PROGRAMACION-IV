package PRACTICA

//PIDE 3 NOTAS (0-20)
//PROMEDIA Y DICE "APROBADO" SI >=14 SI  NO "REPROBADO"

fun main() {
    val notas = mutableListOf<Double>()

    for (i in 1..3) {
        print("Ingresar nota $i (0-20): ")
        val nota = readln().toDoubleOrNull()

        if (nota == null || nota !in 0.0..20.0) {
            println("Ingresar una nota valida entre 0 y 20")
            return
        }
        notas.add(nota)
    }
    val promedio = notas.sum() / notas.size
    println("Promedio: $promedio")

    if (promedio >= 14) {
        println("Aprobado")
    } else {
        println("Reprobado")
    }
}