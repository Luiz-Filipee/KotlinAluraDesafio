package br.com.alura.alugames.model

import java.time.LocalDate

class PlanoAssinatura(
    tipo: String,
    val mensaldade: Double,
    val jogosIncluidos: Int
    ) : Plano(tipo)
{
    override fun obterValor(aluguel: Aluguel): Double {
        val totalJogosNoMes = aluguel.game.JogoDoMes(aluguel.periodo.dataInicial.monthValue).size+1
        return if(totalJogosNoMes <= jogosIncluidos){
            00.00
        }else{
            super.obterValor(aluguel)
        }
    }
}

