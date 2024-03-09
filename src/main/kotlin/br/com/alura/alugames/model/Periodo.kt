package br.com.alura.alugames.model

import java.time.LocalDate
import java.time.Period

data class Periodo(
    val dataInicial: LocalDate = LocalDate.now(),
    val dataFinal: LocalDate = LocalDate.now().plusDays(7)){
    val emDias = Period.between(dataInicial, dataFinal).days
}
