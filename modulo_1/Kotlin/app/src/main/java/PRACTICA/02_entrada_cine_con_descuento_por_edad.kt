package PRACTICA

//Entrada de cine con descuento por edad
//pide edad base $5
//<12 -> $3
//>= 65 -> $4
//si no $5

fun main() {
    print("Ingresar la edad: ")
    val edad = readln().toIntOrNull()

    if (edad == null) {
        print("Ingresar una edad valida")
    }else {
        val precio = if (edad < 12) {
            3
        }else if (edad >= 65) {
            4
        }else {
            5
        }
        println("El precio de su entrada es: $precio")
    }
}