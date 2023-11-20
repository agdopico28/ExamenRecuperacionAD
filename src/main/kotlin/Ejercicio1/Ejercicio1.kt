package Ejercicio1

import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader

fun main(args: Array<String>) {
    listDirectory()
    ///home/INFORMATICA/alu10701951/Escriptori/P1
}

fun listDirectory() {
    println(" ")
    println("Introduce una ruta:")
    val input = BufferedReader(InputStreamReader(System.`in`)).readLine()
    val f= File(input)
    val s = "Llista de fitxers i directoris del directorios de la ruta " + f.path
    println(s)
    println("--------------------------------------------------------------")

    var contadorMayorCinco = 0
    var tamanyoTotal = 0
    var tamanyoMaximo = 0
    var ficheroMayor = ""
    val listaDeFicheros = mutableListOf<String>()
    val diccionario: MutableMap<String, Int> = mutableMapOf()

    for (e in f.walk().sorted()) {

        if (e.isFile) {
            if (e.length().toInt() > 5) {
                contadorMayorCinco++
                listaDeFicheros.add(e.name)
                tamanyoTotal += e.length().toInt()
                diccionario[e.name] = e.length().toInt()
            }
            if (e.length().toInt() > tamanyoMaximo) {
                tamanyoMaximo = e.length().toInt()
                ficheroMayor = e.name
            }
        }

    }

    println("Ficheros con tamaño superior a 5 son: " + contadorMayorCinco)
    println("El array con los ficheros con tamaño superior a 5 es: " + listaDeFicheros)
    println("Con estructura diccionario sale el par: " + diccionario)
    println("El fichero con mayor tamaño es: $ficheroMayor  y su tamaño es: $tamanyoMaximo")
    println("La suma de los ficheros mayores de 5 es: " + diccionario.values.sum())

}
