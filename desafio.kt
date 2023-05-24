// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANÇADO }

class Usuario(val nome: String) {
    override fun toString(): String {
        return nome
    }
}

data class ConteudoEducacional(val nome: String, val duracao: Int = 60, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
}

fun main() {
    val usuario1 = Usuario("James")
    val usuario2 = Usuario("Maria")
    val conteudo1 = ConteudoEducacional("Java", 120, Nivel.INTERMEDIARIO)
    val conteudo2 = ConteudoEducacional("Kotlin", 200, Nivel.BASICO)
    val conteudos = listOf(conteudo1, conteudo2)

    val formacao = Formacao("Formação Supimpa", conteudos)

    var conteudosFormatados = formacao.conteudos.joinToString("\n") { "${it.nome} (${it.duracao} minutos) ${it.nivel}" }
    println("Conteúdos da formação:\n$conteudosFormatados\n")

    formacao.matricular(usuario1)
    formacao.matricular(usuario2)

    println("Usuário(s) matriculado(s) na formação:\n${formacao.inscritos.joinToString("\n")}\n")

    val conteudo3 = ConteudoEducacional("Docker", 90, Nivel.INTERMEDIARIO)
    val conteudo4 = ConteudoEducacional("Método Ágil", 150, Nivel.BASICO)
    val novosConteudos = listOf(conteudo3, conteudo4)

    formacao.conteudos = novosConteudos

    conteudosFormatados = formacao.conteudos.joinToString("\n") { "${it.nome} (${it.duracao} minutos) ${it.nivel}" }
    println("Conteúdos atualizados da formação:\n$conteudosFormatados\n")
}
