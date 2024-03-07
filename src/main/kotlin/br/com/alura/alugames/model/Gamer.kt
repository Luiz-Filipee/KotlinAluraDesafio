package br.com.alura.alugames.model

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*
import kotlin.random.Random

data class Gamer(var nome: String, var email: String) : Recomendavel {
    var dataNascimento: String? = null
    var usuario: String? = null
        set(value) {
            field = value  // Atribuindo o valor que recebo a field
            if (idInterno.isNullOrBlank()) { // Verificando se o idInterno é nulo ou vazio
                criaIdInterno()
            }
        }
    var id = 0
    var idInterno: String? = null
        private set // setando private para nao ser possivel realizar a alteraçao dos dados
    var plano: Plano = PlanoAvulso("BRONZE")
    val jogosBuscados = mutableListOf<Jogo?>()
    val jogosAlugados = mutableListOf<Aluguel>()
    private val listaDeNotas = mutableListOf<Int>()
    val jogosRecomendados = mutableListOf<Jogo>()

    override val media: Double
        get() = listaDeNotas.average().formatoComDuasCasasDecimais()

    override fun recomendar(nota: Int) {
        if(nota >= 1 && nota <= 10){
            listaDeNotas.add(nota)
        }else{
            println("Nota invalida. A nota deve estar entre 1 e 10")
        }
    }

    fun recomendarJogo(jogo: Jogo, nota: Int){
        jogo.recomendar(nota)
        jogosRecomendados.add(jogo)
    }

    constructor(nome: String, email: String, dataNascimento: String, usuario: String, id: Int = 0) :
            this(nome, email) {
        this.dataNascimento = dataNascimento
        this.usuario = usuario
        this.id = id
        criaIdInterno()
    }


    /*init { // Executa antes de executar a classe
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
        return "Gamer(nome='$nome'" +
                ", email='$email'" +
                ", dataNascimento=$dataNascimento" +
                ", usuario=$usuario" +
                ", idInterno=$idInterno" +
                ", Reputação=$media)" +
                ", id=$id"
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

    fun Double.formatoComDuasCasasDecimais(): Double {
        val decimalFormat = DecimalFormat("#.00", DecimalFormatSymbols(Locale.US))
        return decimalFormat.format(this).toDouble()
    }

    fun alugaJogo(jogo: Jogo, periodo: Periodo): Aluguel {
        val aluguel = Aluguel(this, jogo, periodo)
        jogosAlugados.add(aluguel)

        return aluguel
    }

    fun jogoDoMes(mes: Int): List<Jogo> {
        return jogosAlugados
            .filter { aluguel -> aluguel.periodo.dataInicial.monthValue == mes }
            .map { aluguel -> aluguel.jogo }
    }

    companion object {
        fun criaGamer(reader: Scanner): Gamer {
            println("Boas vindas ao AluGames! Vamos fazer seu cadastro. Digite seu nome:")
            val nome = reader.nextLine()
            println("Digite seu e-mail:")
            val email = reader.nextLine()
            println("Deseja completar seu cadastro com usuário e data de nascimento? (S/N)")
            val opcao = reader.nextLine()

            return if (opcao.equals("s", true)) {
                println("Digite sua data de nascimento(DD/MM/AAAA):")
                val data = reader.nextLine()
                println("Digite seu nome de usuario:")
                val usuario = reader.nextLine()

                Gamer(nome, email, data, usuario, )
            } else {
                Gamer(nome, email)
            }
        }
    }


}
