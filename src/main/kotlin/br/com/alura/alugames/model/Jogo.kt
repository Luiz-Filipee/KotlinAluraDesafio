package br.com.alura.alugames.model

data class Jogo(val titulo: String, var capa: String) {
    var descricao: String? = null
    var preco = 0.0

    constructor(titulo: String, capa: String, preco: Double, descricao: String) :
            this(titulo, capa) {
        this.preco = preco
        this.descricao = descricao
    }

    override fun toString(): String {
        return "{\nMeu jogo: \n" +
                "Titulo: $titulo,\n " +
                "capa: '$capa, \n" +
                "descricao: $descricao\n" +
                "Preço: $preco\n}"
    }

}