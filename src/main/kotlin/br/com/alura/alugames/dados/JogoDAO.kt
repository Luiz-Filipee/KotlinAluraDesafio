package br.com.alura.alugames.dao

import br.com.alura.alugames.dados.JogoEntity
import br.com.alura.alugames.model.Jogo
import javax.persistence.EntityManager

class JogoDAO(manager: EntityManager): DAO<Jogo, JogoEntity>(manager, JogoEntity::class.java) {

    override fun toEntity(objeto: Jogo): JogoEntity{
        return JogoEntity(objeto.titulo, objeto.capa, objeto.preco, objeto.descricao, objeto.id)
    }

    override fun toModel(entity: JogoEntity): Jogo {
        return Jogo(entity.titulo, entity.capa, entity.preco, entity.descricao, entity.id)
    }


    /*fun insertJogos(jogo: Jogo) {
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
    }*/
}