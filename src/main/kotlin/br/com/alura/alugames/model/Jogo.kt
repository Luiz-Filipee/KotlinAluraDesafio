package br.com.alura.alugames.model

import com.google.gson.annotations.Expose


data class Jogo(
    @Expose val titulo: String = "Título do jogo",
    @Expose val capa: String = "Capa do jogo"
) : Recomendavel {
    var preco: Double = 0.0
    var descricao: String? = null
    var id: Int = 0
    private val listaNotas: MutableList<Int> = mutableListOf<Int>()

    constructor(titulo: String, capa: String, preco: Double, descricao: String?, id: Int = 0) :
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