package br.com.alura.alugames.utilitario

import br.com.alura.alugames.dados.PlanoAssinaturaEntity
import br.com.alura.alugames.dados.PlanoAvulsoEntity
import br.com.alura.alugames.dados.PlanoEntity
import br.com.alura.alugames.model.Plano
import br.com.alura.alugames.model.PlanoAssinatura
import br.com.alura.alugames.model.PlanoAvulso

fun Plano.toEntity(): PlanoEntity {
    return if (this is PlanoAssinatura) {
        PlanoAssinaturaEntity(this.tipo, this.mensaldade, this.jogosIncluidos, this.percentualDescontoReputacao, this.id)
    } else {
        PlanoAvulsoEntity(this.tipo, this.id)
    }
}

fun PlanoEntity.toModel(): Plano {
    return if (this is PlanoAssinaturaEntity) {
        PlanoAssinatura(this.tipo, this.mensalidade, this.jogosIncluidos, this.percentualDescontoReputacao, this.id)
    } else {
        PlanoAvulso(this.tipo, this.id)
    }
}