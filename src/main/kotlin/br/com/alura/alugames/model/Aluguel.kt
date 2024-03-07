package br.com.alura.alugames.model

import java.text.DecimalFormat

data class Aluguel(
    val game: Gamer,
    val jogo: Jogo,
    val periodo: Periodo
    ) {

    val valorAluguel = jogo.preco * periodo.emDias
    val formatado: DecimalFormat = DecimalFormat("#,###.00")

    override fun toString(): String {
        return "Aluguel(=$game, jogo = $jogo, valor = ${formatado.format(valorAluguel)})"
    }
}