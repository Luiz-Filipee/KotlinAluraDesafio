package br.com.alura.alugames.principal

import br.com.alura.alugames.dao.JogoDAO
import br.com.alura.alugames.model.Jogo

fun main() {

    /*val stmt = conexao?.createStatement()
    val sql = "SELECT * FROM jogos"
    val rs = stmt?.executeQuery(sql)

    if (rs != null) {
        while (rs?.next() == true){
            println("# ${rs?.getInt("id")} # ${rs?.getString("titulo")}")
        }
    }
    rs?.close()
    stmt?.close()

    conexao?.close()*/

    //val listaJogos: List<Jogo> = Banco.getJogos()
    //println(listaJogos)


    val jogo = Jogo(
        "The Last of Us Part I",
        "https://cdn.cloudflare.steamstatic.com/steam/apps/1888930/header.jpg?t=1686864554",
        5.99,
        "Uma aventura pós-apocalíptica de sobrevivência em um mundo infestado por zumbis e facções em conflito."
    )
    val jogoDAO = JogoDAO()
    jogoDAO.insertJogos(jogo)
    val listaJogos: List<Jogo> = jogoDAO.getJogos()
    println(listaJogos)
}