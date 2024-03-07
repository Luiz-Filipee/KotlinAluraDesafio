package br.com.alura.alugames.dao

import br.com.alura.alugames.dados.Banco
import br.com.alura.alugames.model.Jogo

class JogoDAO {
    fun insertJogos(jogo: Jogo) {
        val conexao = Banco.obterConexao()
        val sql = "INSERT INTO jogos(TITULO, CAPA, PRECO, DESCRICAO) VALUES (?,?,?,?)"
        if(conexao != null){
           try {
               val statement = conexao.prepareStatement(sql)
               statement.setString(1,jogo.titulo)
               statement.setString(2,jogo.capa)
               statement.setDouble(3,jogo.preco)
               statement.setString(4,jogo.descricao)
               val resultado = statement.executeUpdate()
               if(resultado == 1){
                   println("Dados inseridos com sucesso")
               }else{
                   println("Dados incorretos. Tente novamente")
               }
               statement.close()
           }finally {
               conexao.close()
           }


        }

    }

    fun getJogos(): List<Jogo> {
        val listaJogos = mutableListOf<Jogo>()
        val conexao = Banco.obterConexao()
        if (conexao != null) {
            try {
                val statement = conexao.createStatement()
                val sql = "SELECT * FROM jogos"
                val resultado = statement.executeQuery(sql)

                while (resultado.next()) {
                    val id = resultado.getInt("id")
                    val titulo = resultado.getString("titulo")
                    val capa = resultado.getString("capa")
                    val descricao = resultado.getString("descricao")
                    val preco = resultado.getDouble("preco")

                    val jogo = Jogo(titulo, capa, preco, descricao, id)
                    listaJogos.add(jogo)
                }


                statement.close()
            } finally {
                conexao.close()
            }
        }
        return listaJogos
    }
}