package br.com.alura.alugames.utilitario

import br.com.alura.alugames.dados.GamerEntity
import br.com.alura.alugames.model.Gamer
import br.com.alura.alugames.model.InfoGameJson


fun InfoGameJson.criaGamer(): Gamer {
    return Gamer(
        this.nome,
        this.email,
        this.dataNascimento,
        this.usuario
    )
}

fun Gamer.toEntitty(): GamerEntity{
    return GamerEntity(this.id, this.nome, this.email, this.dataNascimento, this.usuario, this.plano.toEntity())
}

fun GamerEntity.toModel(): Gamer{
    return Gamer(this.nome, this.email, this.dataNascimento, this.usuario, this.id)
}