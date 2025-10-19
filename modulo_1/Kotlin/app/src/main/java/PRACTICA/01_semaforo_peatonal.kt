package PRACTICA

//SEMAFORO PEATONAL
//PIDE COLOR DE SEMAFORO("rojo","amarillo", "verde") y si el peaton presiono
//EL BOTON ("si/no")
//SI ESTA VERDE Y PRESIONO -> "ESPERA A ROJO"
//SI ESTA ROJO -> "CRUZA
//SI ESTA AMARILLO -> "PREPARATE"
//EN OTROS CASOS -> "ESPERA"

fun main() {
    print("Ingresar el color del semaforo (rojo, amarillo, verde): ")
    val color = readln().lowercase()

    print("El usuario presiono el boton (si/no): ")
    val boton = readln().lowercase()

    if (color == "verde" && boton == "si") {
        print("Espera a rojo")
    } else if (color == "rojo") {
        print("Cruza")
    }else if (color == "amarillo") {
        print("Preparate")
    }else {
        println("Espera")}
}