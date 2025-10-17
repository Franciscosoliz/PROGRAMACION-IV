package PRACTICA

//BUCLE DE MENU:
//1)SUMAR
//2)RESTAR
//3)SALIR
//TRAS CADA OPERACION MOSTRAR RESULTADO

fun main() {
    var opcion: Int
    do {
        println("\n--- MENU ---")
        println("1) Sumar")
        println("2) Restar")
        println("3) Salir")
        print("Seleccione una opcion: ")

        opcion = readln().toIntOrNull() ?: -1

        when (opcion) {
            1 -> {
                print("Ingrese primer numero: ")
                val a = readln().toDoubleOrNull() ?: 0.0
                print("Ingrese segundo numero: ")
                val b = readln().toDoubleOrNull() ?: 0.0
                val resultado = a + b
                println("Resultado de la suma: $resultado")
            }
            2 -> {
                print("Ingrese primer numero: ")
                val a = readln().toDoubleOrNull() ?: 0.0
                print("Ingrese segundo numero: ")
                val b = readln().toDoubleOrNull() ?: 0.0
                val resultado = a - b
                println("Resultado de la resta: $resultado")
            }
            3 -> println("Salir")
            else -> println("Opcion no valida")
        }
    } while (opcion != 3)
}