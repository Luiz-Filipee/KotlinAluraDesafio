package br.com.alura.alugames.utilitario

class Box<T>(t: T) {
    var value = t
}
fun main(){
    Box(1)
    Box(1.0)
    Box("name")
    Box('x')
}