package PRACTICA

//PIDE TEXTO Y CUENTA VOCALES (a,e,i,o,u) SIN TILDES

fun main() {
    print("Ingresar texto: ")
    val texto = readln().lowercase()
    var contador = 0

    for (c in texto) {
        if (c in listOf('a', 'e', 'i', 'o', 'u')) {
            contador++
        }
    }
    println("El texto tiene $contador vocales (a, e, i, o, u).")
}