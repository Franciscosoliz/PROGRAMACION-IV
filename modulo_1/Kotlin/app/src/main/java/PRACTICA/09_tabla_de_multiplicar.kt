package PRACTICA

//PIDE UN NUMERO Y MUESTRA SU TABLA HASTA 10

fun main() {
    print("Ingresar numero: ")
    val numero = readln().toIntOrNull()

    if (numero == null) {
        println("Ingresar un numero valido.")
    } else {
        println("Tabla de multiplicar del $numero:")

        for (i in 1..10) {
            println("$numero x $i = ${numero * i}")
        }
    }
}
