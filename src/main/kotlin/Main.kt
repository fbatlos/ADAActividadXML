package org.example

import org.example.Repository.NoticiasRepository
import org.example.Repository.empleadosRepository
import java.nio.file.Path

fun main() {

    //Actividad Empleados
    val path = Path.of("src/main/resources/")
    val empleados = empleadosRepository()
   // empleados.mostrarDosMil(path)
    val lista = empleados.DatosEmpleado(path)
   // println(lista)

    //Actividad Agencia tribbutaria

    val agencia = NoticiasRepository()
    val listaAgencia = agencia.ListaNoticia(path)

    listaAgencia.forEach { println(it.toString()) }
}