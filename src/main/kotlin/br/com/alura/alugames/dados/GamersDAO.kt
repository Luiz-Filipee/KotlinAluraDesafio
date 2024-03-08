package br.com.alura.alugames.dados

import br.com.alura.alugames.model.Gamer
import javax.persistence.EntityManager

class GamersDAO(manager: EntityManager): DAO<Gamer, GamersEntity>(manager, GamersEntity::class.java){

    override fun toEntity(objeto: Gamer): GamersEntity {
        return GamersEntity(objeto.nome, objeto.email, objeto.dataNascimento, objeto.usuario, objeto.id)
    }

    override fun toModel(entity: GamersEntity): Gamer {
        return Gamer(entity.nome, entity.email, entity.dataNascimento, entity.usuario, entity.id)
    }
}