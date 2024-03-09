package br.com.alura.alugames.utilitario

import br.com.alura.alugames.dados.JogoEntity
import br.com.alura.alugames.model.InfoJogoJson
import br.com.alura.alugames.model.Jogo

fun InfoJogoJson.criaJogo(): Jogo{
    return Jogo(this.titulo, this.capa, this.preco, this.descricao)
}

fun Jogo.toEntity(): JogoEntity{
    return JogoEntity(this.titulo, this.capa, this.preco, this.descricao, this.id)
}

fun JogoEntity.toModel():Jogo{
    return Jogo(this.titulo, this.capa, this.preco, this.descricao, this.id)
}