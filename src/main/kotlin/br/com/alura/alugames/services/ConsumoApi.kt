package br.com.alura.alugames.services

import br.com.alura.alugames.model.*
import br.com.alura.alugames.utilitario.criaGamer
import br.com.alura.alugames.utilitario.criaJogo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ConsumoApi {
    fun buscaJogo(id: String): InfoJogo {

        val endereco = "https://www.cheapshark.com/api/1.0/games?id=$id"

        val json = consomeDados(endereco)

        val gson = Gson()
        val meuInfoJogo = gson.fromJson(json, InfoJogo::class.java)

        return meuInfoJogo
    }

    fun buscaGamer(): List<Gamer> {

        val endereco = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"

        val json = consomeDados(endereco)

        val gson = Gson()
        var meuGamerTipo = object : TypeToken<List<InfoGameJson>>() {}.type
        val listaGamer: List<InfoGameJson> = gson.fromJson(json, meuGamerTipo)

        // Transformando o infoGameJson em um Gamer
        val listaGamerConvertido = listaGamer.map { infoGameJson -> infoGameJson.criaGamer() }

        return listaGamerConvertido
    }

    fun buscaJogoJson(): List<Jogo> {
        val endereco = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json"
        val json = consomeDados(endereco);

        val gson = Gson();
        val meuJogoTipo = object : TypeToken<List<InfoJogoJson>>() {}.type
        val listaJogo: List<InfoJogoJson> = gson.fromJson(json, meuJogoTipo)

        val listaJogosConvertido = listaJogo.map { infoJogoJson -> infoJogoJson.criaJogo() }

        return listaJogosConvertido
    }

    private fun consomeDados(endereco: String): String? {
        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .build()
        val response = client
            .send(request, HttpResponse.BodyHandlers.ofString())

        return response.body()
    }
}