enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val id: Int, val nome: String, val nivel: Nivel)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>) {
    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }

    fun mostrarInscritos() {
        println("Inscritos em $nome:")
        inscritos.forEach { println("${it.nome} - ${it.nivel}") }
    }
}

val formacoes = mutableListOf<Formacao>()

fun criarFormacao(nome: String, conteudos: List<ConteudoEducacional>) {
    formacoes.add(Formacao(nome, conteudos))
}

fun listarFormacoes() {
    println("Formações disponíveis:")
    formacoes.forEachIndexed { index, formacao ->
        println("$index. ${formacao.nome}")
    }
}

fun main() {
    criarFormacao("Formação Básica", listOf(ConteudoEducacional("Introdução ao Kotlin"), ConteudoEducacional("Estruturas de Controle")))
    criarFormacao("Formação Intermediária", listOf(ConteudoEducacional("Programação Orientada a Objetos"), ConteudoEducacional("Collections em Kotlin")))
    criarFormacao("Formação Avançada", listOf(ConteudoEducacional("Tópicos Avançados"), ConteudoEducacional("Projeto Final")))

    listarFormacoes()

    val escolhaFormacao = readLine()?.toIntOrNull()
    
    if (escolhaFormacao != null && escolhaFormacao < formacoes.size) {
        val formacaoEscolhida = formacoes[escolhaFormacao]
        
        val usuario = Usuario(1, "Luiz", Nivel.BASICO)
        formacaoEscolhida.matricular(usuario)
        
        val msg = when (usuario.nivel) {
            Nivel.BASICO -> "Seja bem-vindo ${usuario.nome} à formação Básica, parabéns"
            Nivel.INTERMEDIARIO -> "Seja bem-vindo ${usuario.nome} à formação Intermediária, parabéns"
            Nivel.DIFICIL -> "Seja bem-vindo ${usuario.nome} à formação Avançada, parabéns"
        }
        
        println(msg)
        
        formacaoEscolhida.mostrarInscritos()
    } else {
        println("Escolha inválida.")
    }
}
