package br.com.alura.alugames.model

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

data class Aluguel(
    val game: Gamer,
    val jogo: Jogo,
    val periodo: Periodo,
    ) {
    var id = 0
    val valorAluguel = game.plano.obterValor(this)
    val formatado: DecimalFormat = DecimalFormat("#.00", DecimalFormatSymbols(Locale.US))



    override fun toString(): String {
        return "Aluguel(=$game, jogo = $jogo, valor R$ ${formatado.format(valorAluguel)}, id = $id)"
    }
}