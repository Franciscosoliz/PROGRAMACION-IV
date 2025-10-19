package PRACTICA

//Pide N y suma los multiplos de 3 desde 1..N

fun main() {
    print("Ingrese un numero N: ")
    val n = readln().toIntOrNull()

    if (n == null || n < 1) {
        println("Ingrese un numero valido mayor a 0")
    } else {
        var suma = 0
        var i = 1

        while (i <= n) {
            if (i % 3 == 0) {
                suma += i
            }
            i++
        }
        println("La suma de los multiplos de 3 entre 1 y $n es: $suma")
    }
}