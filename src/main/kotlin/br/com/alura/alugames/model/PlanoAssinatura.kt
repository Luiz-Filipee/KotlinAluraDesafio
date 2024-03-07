package br.com.alura.alugames.model

import java.time.LocalDate

class PlanoAssinatura(
    tipo: String,
    val mensaldade: Double,
    val jogosIncluidos: Int,
    val percentualDescontoReputacao: Double,
    id: Int = 0
) : Plano(tipo, id)
{

    override fun obterValor(aluguel: Aluguel): Double {
        val totalJogosNoMes = aluguel.game.jogoDoMes(aluguel.periodo.dataInicial.monthValue).size+1
        return if(totalJogosNoMes <= jogosIncluidos){
            00.00
        }else{
            var valorOriginal = super.obterValor(aluguel)
            if (aluguel.game.media > 8){
                valorOriginal -= valorOriginal * percentualDescontoReputacao
            }
            valorOriginal
        }
    }

    override fun toString(): String {
        return "PlanoAssinatura(mensaldade=$mensaldade\n" +
                ", jogosIncluidos=$jogosIncluidos\n" +
                ", percentualDescontoReputacao=$percentualDescontoReputacao\n)"
    }


}

