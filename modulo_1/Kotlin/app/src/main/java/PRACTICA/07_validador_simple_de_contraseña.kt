package PRACTICA

//PIDE CONTRASEÑA
//VALIDA SI TIENE >=8 CARACTERES Y CONTIENE AL MENOS UN DIGITO

fun main() {
    print("Ingrese contraseña: ")
    val contraseña = readln()
    val longitudValida = contraseña.length >= 8
    val tieneDigito = contraseña.any { it.isDigit() }

    if (longitudValida && tieneDigito) {
        println("Contraseña correcta")
    } else {
        println("Contraseña incorrecta")
        if (!longitudValida) println("Debe tener 8 caracteres")
        if (!tieneDigito) println("Debe tener al menos un dígito")
    }
}