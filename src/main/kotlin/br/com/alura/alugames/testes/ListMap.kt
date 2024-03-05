package br.com.alura.alugames.testes

class ListMap {
}

fun main(){
    val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key4" to 4)

    println("Todas as chaves: ${numbersMap.keys}")
    println("Todos os valores: ${numbersMap.values}")
    if("key2" in numbersMap)
        println("valor por chave 'key2': ${numbersMap["key2"]} ")
    if(1 in numbersMap.values)
        println("O valor 1 esta no mapa")
    if (numbersMap.containsValue(1))
        println("O valor 1 esta no mapa")

}