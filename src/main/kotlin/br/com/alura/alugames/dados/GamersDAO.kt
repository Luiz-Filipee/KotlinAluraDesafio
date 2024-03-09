package br.com.alura.alugames.dados

import br.com.alura.alugames.model.Gamer
import br.com.alura.alugames.utilitario.toEntity
import java.net.DatagramPacket
import javax.persistence.EntityManager

class GamersDAO(manager:EntityManager): DAO<Gamer, GamerEntity>(manager, GamerEntity::class.java) {
    override fun toEntity(objeto: Gamer): GamerEntity {
       return GamerEntity(objeto.id, objeto.nome, objeto.email,
           objeto.dataNascimento, objeto.usuario, objeto.plano.toEntity())
    }

    override fun toModel(entity: GamerEntity): Gamer {
        return Gamer(entity.nome, entity.email, entity.dataNascimento, entity.usuario,
            entity.id)
    }
}