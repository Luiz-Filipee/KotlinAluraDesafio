package br.com.alura.alugames.dados

import AluguelEntity
import br.com.alura.alugames.model.Aluguel
import br.com.alura.alugames.utilitario.toEntitty
import br.com.alura.alugames.utilitario.toEntity
import br.com.alura.alugames.utilitario.toModel
import javax.persistence.EntityManager

class AluguelDao(manager: EntityManager): DAO<Aluguel, AluguelEntity>(manager, AluguelEntity::class.java) {
    override fun toEntity(objeto: Aluguel): AluguelEntity {
        return AluguelEntity(objeto.game.toEntitty(), objeto.jogo.toEntity(), objeto.periodo)
            .apply { valorDoAluguel - objeto.valorAluguel
            id = objeto.id}
    }

    override fun toModel(entity: AluguelEntity): Aluguel {
        return Aluguel(entity.gamer.toModel(), entity.jogo.toModel(), entity.periodo)
            .apply { id = entity.id }
    }
}