//contar y mostrar los numeros divisibles para 3 y 5 qe onfrese el usuario

package com.example.basics

fun main() {
    print("ingrese")
    val numero = readln().toIntOrNull()
    if (numero == null){
        print("ingrese un numero correcto")
    }
    else{
    var contador = 0
    var i = 1

    while (i <= numero) {
        if (numero % 3 == 0 && numero %5 == 0) {
            print("contar los numeros divisibles entre 3 y 5: $i")
            contador ++
        }
        i ++
    }
        print("total de numero divisibles entre  3 y 5: $numero: $contador")
    }
}