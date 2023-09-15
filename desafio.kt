enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val id: Int, val nome: String)

fun usuarios(): Usuario {
    return Usuario(1, "Luiz")
}

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
}

fun main() {
    val status = Nivel.BASICO
    val usuario = usuarios()
    val msg = when (status) {
        Nivel.BASICO -> "Seja bem vindo ${usuario.nome} ao módulo Básico, parabéns"
        Nivel.INTERMEDIARIO -> "Seja bem vindo ${usuario.nome} ao  Intermediário, parabéns"
        Nivel.DIFICIL -> "Seja bem vindo ${usuario.nome} ao módulo Difícil, parabéns"
    }


    println(msg)
   
}
