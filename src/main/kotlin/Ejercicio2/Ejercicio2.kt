package Ejercicio2

import java.io.*

fun main(args: Array<String>) {
    val fData = DataInputStream(FileInputStream("Alumnes.dat"))
    val fTxt = BufferedReader(FileReader ("Alumnes.txt"))
    val output = PrintWriter(FileWriter("Resum.txt"))
    var datos = fTxt.readLine()

    while (datos != null){
        val string = "DNI: " + datos + " Nom: " + fData.readUTF()

        val primeraNota = fData.readFloat()
        val segundaNota = fData.readFloat()
        val terceraNota = fData.readFloat()
        val mediaNotas = (primeraNota + segundaNota + terceraNota)/3

        val stringFinal = string +"\nNotes: " + primeraNota + " "+segundaNota+  " "+terceraNota+
                "\nNota mitjana: " + mediaNotas

        output.write(
            stringFinal + "\n-------------------------------\n"
        )

        println(stringFinal + "\n-------------------------------")
        datos = fTxt.readLine()

    }
    fData.close()
    fTxt.close()
    output.close()

}