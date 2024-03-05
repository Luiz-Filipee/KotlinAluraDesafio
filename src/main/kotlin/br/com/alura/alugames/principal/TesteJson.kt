package br.com.alura.alugames.principal

import br.com.alura.alugames.services.ConsumoApi

fun main() {
    val consumo = ConsumoApi()
    val listaGames = consumo.buscaGamer()
    val busca = consumo.buscaJogo("141")
    val buscaJogoJson = consumo.buscaJogoJson()

    println(listaGames)
    println(busca)
    println(buscaJogoJson)
}