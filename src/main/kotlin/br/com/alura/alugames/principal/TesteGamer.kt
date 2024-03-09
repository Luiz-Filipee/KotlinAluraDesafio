package br.com.alura.alugames.principal

import br.com.alura.alugames.dados.Banco
import br.com.alura.alugames.dados.GamersDAO
import br.com.alura.alugames.dados.PlanosDAO
import br.com.alura.alugames.model.Gamer

fun main() {
    val gamer = Gamer("Monica", "monica@email.com", "15/03/1995", "moni")

    val manager = Banco.getEntityManager()
    val gamerDAO = GamersDAO(manager)


    val listaGamersBanco = gamerDAO.getLista()
    println(listaGamersBanco)

    manager.close()
}


