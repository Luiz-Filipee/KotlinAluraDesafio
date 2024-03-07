package br.com.alura.alugames.dados

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

object Banco {
    fun obterConexao(): Connection? {
        return try {
            DriverManager.getConnection("jdbc:postgresql://localhost:5432/alugames", "postgres", "password")
        } catch (e: SQLException) {
            e.printStackTrace()
            null
        }
    }
}