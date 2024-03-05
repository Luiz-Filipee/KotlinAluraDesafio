package br.com.alura.alugames.model

import java.util.Scanner
import kotlin.random.Random

data class Gamer(var nome: String, var email: String) {
    var dataNascimento: String? = null
    var usuario: String? = null
        set(value) {
            field = value  // Atribuindo o valor que recebo a field
            if (idInterno.isNullOrBlank()) { // Verificando se o idInterno é nulo ou vazio
                criaIdInterno()
            }
        }
    var idInterno: String? = null
        private set // setando private para nao ser possivel realizar a alteraçao dos dados

    val jogosBuscados = mutableListOf<Jogo?>()

    constructor(nome: String, email: String, dataNascimento: String, usuario: String):
            this(nome, email) {
        this.dataNascimento = dataNascimento;
        this.usuario = usuario;
        criaIdInterno()
    }

    /*
    init { // Executa antes de executar a classe
        this.email = validarEmail()
        kotlin.runCatching {
            if (nome.isNullOrBlank()) {
                throw IllegalArgumentException("Nome está em branco")
            }
        }.onFailure {
            println("Informe um nome valido")
        }.onSuccess {
            println("dados cadastrados")
        }
    }*/


    override fun toString(): String {
        return "Gamer(nome='$nome', email='$email', dataNascimento=$dataNascimento, usuario=$usuario, idInterno=$idInterno)"
    }

    fun criaIdInterno() {
        val numero = Random.nextInt(10000)
        val tag = String.format("%04d", numero)

        idInterno = "$usuario#$tag"
    }

    fun validarEmail(): String {
        val regex = Regex(pattern = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if (regex.matches(email)) {
            return email
        } else {
            throw IllegalArgumentException("Email inválido")
        }
    }

    companion object{
        fun criaGamer(reader: Scanner): Gamer{
            println("Boas vindas ao AluGames! Vamos fazer seu cadastro. Digite seu nome:")
            val nome = reader.nextLine()
            println("Digite seu e-mail:")
            val email = reader.nextLine()
            println("Deseja completar seu cadastro com usuário e data de nascimento? (S/N)")
            val opcao = reader.nextLine()

            if(opcao.equals("s",true)){
                println("Digite sua data de nascimento(DD/MM/AAAA):")
                val data = reader.nextLine()
                println("Digite seu nome de usuario:")
                val usuario = reader.nextLine()

                return Gamer(nome, email, data, usuario)
            }else{
                return  Gamer(nome, email)
            }
        }
    }
}
