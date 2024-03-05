package br.com.alura.alugames.principal

import br.com.alura.alugames.model.Gamer
import br.com.alura.alugames.model.Jogo
import br.com.alura.alugames.services.ConsumoApi
import transformarEmIdade
import java.util.*

fun main() {
    val reader = Scanner(System.`in`)
    val gamer = Gamer.criaGamer(reader)
    val cadastro = runCatching {
        println("Cadastro concluido com sucesso; Dados do gamer:")
        println(gamer)
        println("Idade do gamer: " + gamer.dataNascimento?.transformarEmIdade())
    }
    cadastro.onFailure {
        println(it.message)
        System.exit(0)
    }

    do {
        println("Informe um id para buscar um game: ")
        val resposta = reader.next()

        val buscaApi = ConsumoApi()
        val informacaoJogo = buscaApi.buscaJogo(resposta)

        var meuJogo: Jogo? = null

        val result = runCatching {
            meuJogo = Jogo(
                informacaoJogo.info.title,
                informacaoJogo.info.thumb
            )
        }

        result.onFailure {
            println("br.com.alura.alugames.model.Jogo inexistente. Tente outro id")
        }

        result.onSuccess {
            println("Quer adicionar uma descriçao: S/N")
            val opcao = reader.next()
            reader.nextLine()
            if (opcao.equals("s", ignoreCase = true)) {
                println("Informe a descrição personalizada para o jogo: ")
                val descPersonalizada = reader.nextLine()
                meuJogo?.descricao = descPersonalizada
            } else {
                meuJogo?.descricao = meuJogo?.titulo
            }

            gamer.jogosBuscados.add(meuJogo)
        }

        println("Você buscar um novo jogo? S/N ")
        val response = reader.nextLine()

    } while (response.equals("s", true))

    println("Jogos buscados:")
    println(gamer.jogosBuscados)

    println("Jogos ordenados por titulo: ")
    gamer.jogosBuscados.sortBy {
        it?.titulo
    }

    gamer.jogosBuscados.forEach {
        println("Titulo: " + it?.titulo)
    }

    val jogosFiltrados = gamer.jogosBuscados.filter {
        it?.titulo?.contains("batman",true) ?: false
    }

    println("Jogos filtrados: ")
    println(jogosFiltrados)

    println("Deseja remover algum jogo da lista original: ")
    val op = reader.nextLine();
    if(op.equals("s",true)){
        println(gamer.jogosBuscados)
        println("OBS: a posição inicial começa em: 0")
        println("Informe a posição do jogo: S/N ")
        val position = reader.nextInt()
        gamer.jogosBuscados.removeAt(position)
    }

    println("Lista atualizada: ")
    println(gamer.jogosBuscados)

    println("Busca finalizada com sucesso")
}



