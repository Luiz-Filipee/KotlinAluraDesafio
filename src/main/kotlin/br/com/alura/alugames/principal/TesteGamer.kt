package br.com.alura.alugames.principal

import br.com.alura.alugames.model.Gamer

fun main(){
    val gamer1 = Gamer("luizfilipe","luizkato8@gmail.com")
    println(gamer1)

    val gamer2 = Gamer("raiany","raiany@gmail.com",
        "09/11/2003","raianyrocha")
    println(gamer2)

    gamer1.let {
        it.dataNascimento = "18/09/2000"
        it.usuario = "LuizFilipe"
    }.also {
        println(gamer1.idInterno)
    }

    println(gamer1)
    gamer1.usuario = "jacque"
    println(gamer1)

    gamer2.usuario = "meuamor"
    gamer2.let {
        it.dataNascimento = "11/05/2004"
    }.also {
        println(gamer2)
    }
}


