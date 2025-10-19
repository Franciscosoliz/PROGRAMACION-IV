package PRACTICA

//PIDE ºC
//<= -> SOLIDO
//1..99 -> LIQUIDO
//>= 100 -> GAS

fun main() {
    print("Ingresar la temperatura en °C: ")
    val temperatura = readln().toDoubleOrNull()

    if (temperatura == null) {
        println("Ingresar una temperatura válida")
    } else {
        if (temperatura <= 0) {
            println("Estado: Solido")
        } else if (temperatura in 1.0..99.0) {
            println("Estado: Liquido")
        } else if (temperatura >= 100) {
            println("Estado: Gas")
        }
    }
}