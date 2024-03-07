package br.com.alura.alugames.model

import com.google.gson.annotations.Expose

data class Jogo(
    @Expose val titulo: String,
    @Expose var capa: String
) : Recomendavel {
    var id = 0
    var descricao: String? = null
    var preco = 0.0
    private val listaNotas = mutableListOf<Int>()

    constructor(titulo: String, capa: String, preco: Double, descricao: String, id: Int = 0) :
            this(titulo, capa) {
        this.preco = preco
        this.descricao = descricao
        this.id = id
    }

    override val media: Double
        get() = listaNotas.average()

    override fun recomendar(nota: Int) {
        listaNotas.add(nota)
    }

    override fun toString(): String {
        return "{\nJogo: \n" +
                "Titulo: $titulo,\n " +
                "capa: '$capa, \n" +
                "descricao: $descricao\n" +
                "Preço: $preco\n" +
                "Reputação: $media, \n" +
                "Id: $id \n}"
    }

}