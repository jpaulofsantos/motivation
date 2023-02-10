package com.example.motivation.data

import com.example.motivation.utils.MotivationConstants
import kotlin.random.Random

data class Phrase(val description: String, val categoryId: Int)

class PhraseMock {

    private val listPhrase = listOf<Phrase>(
        Phrase("Nem todas as tempestades vêm para atrapalhar a sua vida. Algumas vêm para limpar seu caminho.", MotivationConstants.FILTER.LEFT),
        Phrase("A persistência realiza o impossível.", MotivationConstants.FILTER.LEFT),
        Phrase("Não se desespere quando a caminhada estiver difícil, é sinal de que você está no caminho certo.", MotivationConstants.FILTER.LEFT),
        Phrase("Seus sonhos não precisam de plateia, eles só precisam de você.", MotivationConstants.FILTER.LEFT),
        Phrase("As pessoas costumam dizer que a motivação não dura sempre. Bem, nem o efeito do banho, por isso recomenda-se diariamente.", MotivationConstants.FILTER.CENTER),
        Phrase("Motivação é a arte de fazer as pessoas fazerem o que você quer que elas façam porque elas o querem fazer.", MotivationConstants.FILTER.CENTER),
        Phrase("Toda ação humana, quer se torne positiva ou negativa, precisa depender de motivação.", MotivationConstants.FILTER.CENTER),
        Phrase("No meio da dificuldade encontra-se a oportunidade.", MotivationConstants.FILTER.CENTER),
        Phrase("Lute. Acredite. Conquiste. Perca. Deseje. Espere. Alcance. Invada. Caia. Seja tudo o quiser ser, mas, acima de tudo, seja você sempre.", MotivationConstants.FILTER.RIGHT),
        Phrase("Eu faço da dificuldade a minha motivação. A volta por cima vem na continuação.", MotivationConstants.FILTER.RIGHT),
        Phrase("Tudo o que um sonho precisa para ser realizado é alguém que acredite que ele possa ser realizado.", MotivationConstants.FILTER.RIGHT),
        Phrase("Coragem é a resistência ao medo, domínio do medo, e não a ausência do medo.", MotivationConstants.FILTER.RIGHT),
    )

    fun ramdomPhrase(id: Int): Phrase {
        var newList = mutableListOf<Phrase>()
        for (i in listPhrase) {
            if (i.categoryId == id) {
                newList.add(i)
            }
        }
        return newList.random()
    }

    fun getPhrase(id: Int): String {
        val lista = listPhrase.filter { it.categoryId == id }
        val index = Random.nextInt(lista.size)
        return lista[index].description
    }

    fun ramdomPhraseAll(id: Int): Phrase {
        var newList = mutableListOf<Phrase>()
        for (i in listPhrase) {
            if (i.categoryId == id) {
                newList.add(i)
            } else if (id == 1) {
                return listPhrase.random()
            }
        }
        return newList.random()
    }
}