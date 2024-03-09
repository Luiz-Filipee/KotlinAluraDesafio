package br.com.alura.alugames.principal

import br.com.alura.alugames.dados.AluguelDao
import br.com.alura.alugames.dados.Banco
import br.com.alura.alugames.dados.GamersDAO
import br.com.alura.alugames.dados.JogosDAO
import br.com.alura.alugames.model.Periodo

fun main(){
    val manager = Banco.getEntityManager()
    val jogosDAO = JogosDAO(manager)
    val gamerDAO = GamersDAO(manager)
    val aluguelDao = AluguelDao(manager)

    val gamer = gamerDAO.recuperarPeloId(1)
    val jogo = jogosDAO.recuperarPeloId(3)
    val aluguel = gamer.alugaJogo(jogo, Periodo())

    aluguelDao.adicionar(aluguel)

    val listaAluguel = aluguelDao.getLista()
    println(listaAluguel)

    manager.close()
}