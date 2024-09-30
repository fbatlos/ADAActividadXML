package org.example

import org.example.Repository.empleadosRepository
import java.nio.file.Path

fun main() {
    val file = Path.of("src").resolve("main/resources/empleados.xml").toFile()
    val empleados = empleadosRepository()
    empleados.mostrar(file)
}