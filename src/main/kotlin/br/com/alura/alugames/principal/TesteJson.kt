package br.com.alura.alugames.principal

import br.com.alura.alugames.model.Periodo
import br.com.alura.alugames.services.ConsumoApi
import java.time.LocalDate
import java.util.*

fun main() {
    val leitura = Scanner(System.`in`)
    val consumo = ConsumoApi()
    val listaGamers = consumo.buscaGamer()
    val listaJogosJson = consumo.buscaJogoJson()

    val gamerCaroline = listaGamers.get(3)
    val jogoResidentVillage = listaJogosJson.get(10)
    val jogoSpider= listaJogosJson.get(13)
    val jogoTheLastOfUs = listaJogosJson.get(2)

    //println(gamerCaroline)
    //println(jogoResidentVillage)

    val periodo = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))
    val periodo2 = Periodo(LocalDate.now(), LocalDate.now().plusDays(3))
    val periodo3 = Periodo(LocalDate.now(), LocalDate.now().plusDays(10))

    gamerCaroline.alugaJogo(jogoResidentVillage, periodo)
    gamerCaroline.alugaJogo(jogoSpider, periodo2)
    gamerCaroline.alugaJogo(jogoTheLastOfUs, periodo3)
    println(gamerCaroline.jogosAlugados)

    /*do{
        println(listaGamers)
        println("Informe o gamer: OBS: primeira posiçao igual a 0 ")
        val gamerSelecionado = leitura.nextInt()
        val gamer = listaGamers.get(gamerSelecionado)
        println(listaJogos)
        println("Informe o jogo que deseja alugar: ")
        val jogoSelecionado = leitura.nextInt()
        val jogo = listaJogos.get(jogoSelecionado)
        println("Por quantos dias deseja alugar o jogo: ")
        val quantidadeDeDias: Long = leitura.nextLong()
        val periodo = Periodo(LocalDate.now(), LocalDate.now().plusDays(quantidadeDeDias))
        var aluguelJogo = gamer.alugaJogo(jogo, periodo)

        aluguelJogos.add(aluguelJogo)

        println("Deseja realizar mais um alugel: S/N")
        val opcao = leitura.next()
        leitura.nextLine()

    }while (opcao.equals("s",true))

    println("Jogos Alugados: ")
    println(aluguelJogos)
    */
}