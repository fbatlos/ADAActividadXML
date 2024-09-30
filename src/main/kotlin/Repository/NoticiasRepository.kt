package org.example.Repository

import org.example.Model.Noticias
import org.w3c.dom.Element
import org.w3c.dom.Node
import java.nio.file.Path
import javax.xml.parsers.DocumentBuilderFactory

class NoticiasRepository {

    fun ListaNoticia(ficheroXML: Path):List<Noticias> {
        val ficheroXML = ficheroXML.resolve("AgenciaTributario.xml").toFile()

        val dbf = DocumentBuilderFactory.newInstance()

        val db = dbf.newDocumentBuilder()

        val documet = db.parse(ficheroXML)

        val root: Element = documet.documentElement
        root.normalize()

        val listaNodos = root.getElementsByTagName("item")

        val listaAgencia = mutableListOf<Noticias>()

        for (i in 0..<listaNodos.length) {
            val nodo = listaNodos.item(i)

            if (nodo.nodeType != Node.ELEMENT_NODE) {

            } else {
                val nodoElemento = nodo as Element

                val elementoTitle = nodoElemento.getElementsByTagName("title")
                val elementoLink = nodoElemento.getElementsByTagName("link")
                val elementoGuid = nodoElemento.getElementsByTagName("guid")
                val elementoPubDate = nodoElemento.getElementsByTagName("pubDate")
                val elementoDescription = nodoElemento.getElementsByTagName("description")


                val textTitle = elementoTitle.item(0).textContent
                val textLink = elementoLink.item(0).textContent
                val textGuid = elementoGuid.item(0).textContent
                val textPubDate = elementoPubDate.item(0).textContent
                val textDescription = elementoDescription.item(0).textContent

                listaAgencia.add(Noticias(textTitle,textLink,textGuid,textPubDate,textDescription))

            }
        }
        return listaAgencia
    }
}