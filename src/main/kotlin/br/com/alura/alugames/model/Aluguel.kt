package br.com.alura.alugames.model

import java.text.DecimalFormat

data class Aluguel(
    val game: Gamer,
    val jogo: Jogo,
    val periodo: Periodo
    ) {

    val valorAluguel = game.plano.obterValor(this)
    val formatado: DecimalFormat = DecimalFormat("#,###.0")

    override fun toString(): String {
        return "Aluguel(=$game, jogo = $jogo, valor R$ ${formatado.format(valorAluguel)})"
    }
}