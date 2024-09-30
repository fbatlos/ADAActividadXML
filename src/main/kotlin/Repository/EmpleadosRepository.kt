package org.example.Repository

import org.example.Model.Empleado
import org.w3c.dom.Element
import org.w3c.dom.Node
import java.nio.file.Path
import javax.xml.parsers.DocumentBuilderFactory

class empleadosRepository () {

    fun mostrarDosMil(ficheroXML: Path) {
        val ficheroXML = ficheroXML.resolve("empleados.xml").toFile()
        val dbf = DocumentBuilderFactory.newInstance()

        val db = dbf.newDocumentBuilder()

        val documet = db.parse(ficheroXML)

        val root: Element = documet.documentElement
        root.normalize()

        val listaNodos = root.getElementsByTagName("empleado")

        for (i in 0..<listaNodos.length) {
            val nodo = listaNodos.item(i)

            if (nodo.nodeType != Node.ELEMENT_NODE) {

            } else {
                val nodoElemento = nodo as Element

                val elementoApellido = nodoElemento.getElementsByTagName("apellido")
                val elementoDepartamento = nodoElemento.getElementsByTagName("dep")
                val elementosalario = nodoElemento.getElementsByTagName("salario")


                val textoApellido = elementoApellido.item(0).textContent
                val textDep = elementoDepartamento.item(0).textContent
                val textSalario = elementosalario.item(0).textContent.toDouble()

                if (textSalario > 2000) {
                    println("${textoApellido}  , Salario : ${textSalario}\n")
                }

            }
        }
    }

    fun DatosEmpleado(ficheroXML: Path): List<Empleado> {
        val ficheroXML = ficheroXML.resolve("empleados.xml").toFile()
        val dbf = DocumentBuilderFactory.newInstance()

        val db = dbf.newDocumentBuilder()

        val documet = db.parse(ficheroXML)

        val root: Element = documet.documentElement
        root.normalize()

        val listaNodos = root.getElementsByTagName("empleado")

        val listaEmpleados = mutableListOf<Empleado>()

        for (i in 0..<listaNodos.length) {
            val nodo = listaNodos.item(i)

            if (nodo.nodeType != Node.ELEMENT_NODE) {

            } else {
                val nodoElemento = nodo as Element

                val elementoApellido = nodoElemento.getElementsByTagName("apellido")
                val elementoDepartamento = nodoElemento.getElementsByTagName("dep")
                val elementosalario = nodoElemento.getElementsByTagName("salario")


                val textoApellido = elementoApellido.item(0).textContent
                val textDep = elementoDepartamento.item(0).textContent
                val textSalario = elementosalario.item(0).textContent.toDouble()

                listaEmpleados.add(Empleado(textoApellido, textDep, textSalario))
            }
        }

        return listaEmpleados

    }
}
