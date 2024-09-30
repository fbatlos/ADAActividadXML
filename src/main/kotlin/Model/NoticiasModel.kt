package org.example.Model

data class Noticias(val title:String, val link:String, val guid:String?, val pubDate:String?, val description:String){
    override fun toString(): String {
        return "$title -\n $link \n -- $guid \t $pubDate \t $description "
    }
}