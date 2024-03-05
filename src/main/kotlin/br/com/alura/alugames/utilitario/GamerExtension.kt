package br.com.alura.alugames.utilitario

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