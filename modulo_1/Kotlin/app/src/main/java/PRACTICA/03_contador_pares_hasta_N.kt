package PRACTICA

//Pide N y cuenta cuantos numeros pares hay entre 1 y N

fun main() {
    print("Ingresa numero N: ")
    val n = readln().toIntOrNull()

    if (n == null || n < 1) {
        println("Ingresa un numero valido mayor a 0")
    }else {
        var contador = 0
        var i = 1

        while (i <= n) {
            if (i %2 == 0) {
                contador++
            }
            i++
        }
        println("entre 1 y $n hay $contador numeros pares")
    }
}