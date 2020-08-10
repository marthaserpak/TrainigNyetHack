package com.bignerdranch.nyethack

import  java.io.File

//TODO(1): Создать таверну, создать меню таверны, считав файл меню в список и разделив на строки.
const val TAVERN_NAME = "Taernyl's Folly"
val menuList = File("src/data/menu.txt").readText().split("\n")

//TODO(3): Создать список имен посетит., список фамилий посетит. Создать пустое множество для уникальных посетител.
val firstName = listOf("Alice", "Gina", "Adler")
val lastName = listOf("Kart", "Mrac", "Virtoc")
val uniquePatrons = mutableSetOf<String>()

val patronGold = mutableMapOf<String, Double>()

fun main() {

    //TODO(2): Отобразить меню при помощи метода forEachIndexed()
    menuList.forEachIndexed { index, menu ->
        println("#${index + 1}: $menu")
    }

    //TODO(4): Рандомно сгенерировать посетителей при помощи forEach() и добавить их в множество.
    (0..4).forEach {
        val first = firstName.shuffled().first()
        val last = lastName.shuffled().first()
        val name = "$first $last"

        uniquePatrons += name
    }
    println()
    println(uniquePatrons)

    //TODO(5): Наполнить кошельки посетителей, добавив ассоциативный массив
    uniquePatrons.forEach {
        patronGold[it] = 6.0
    }


    //TODO(6): Список заказов из случайных имен посетителей и, случайного выбора из меню (с циклом while).
    var countOrder = 0
    while (countOrder <= 4) {
        placeOrder(
            uniquePatrons.shuffled().first(),
            menuList.shuffled().first()
        )
        countOrder++
    }

    performBalances()
}

//TODO(7): функция  com.bignerdranch.nyethack.` `.placeOrder(patron: String, menuData: String), генерирующая заказы:
// 1) Извлечь имя трактирщика из названия таверны и вывести на печать разговор с посетителем
// 2) При помощи деструктуризации разделить строку из меню на отдельные состовляющие
// 3) Записать метод com.bignerdranch.nyethack.` `.performPurchase(price: Double, patron: String)
// 4) Вывести благодарность посетителя за выбранный им напиток
fun placeOrder(patron: String, menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf("\'")
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("$patron speaks with $tavernMaster about their order.")

    val (type, name, price) = menuData.split(",")
    println("$patron ordered  $name ($type) for $price.")

    performPurchase(price.toDouble(), patron)

    if (name == "Dragon's Breath") {
        println("$patron exclaims: ${toDragonSpeak("Ah, how is delicious $name!")}")
    } else println("$patron says: thank u so much for $name!")
}


//TODO(8): Создать метод com.bignerdranch.nyethack.` `.performPurchase(price: Double,  patron: String).
// 1) Переменной totalPurse присваиваем результат полученного значения из com.bignerdranch.nyethack.` `.getPatronGold
// 2) Теперь перебором каждому patron присваиваем остаток, то есть от всех денег у игрока отнимаем цену выбранного напитка
private fun performPurchase(price: Double, patron: String) {
    val totalPurse = patronGold.getValue(patron)
    patronGold[patron] = totalPurse - price
}

//TODO(9): Метод отображения суммы у игрока. Формируем для каждого элемента(посетителя) ассоц. масс. строку остатка баланса
fun performBalances() {
    patronGold.forEach { patron, balance ->
        println("$patron, balance: ${"%.2f".format(balance)}")
    }
}

fun toDragonSpeak(phrase: String) =
    phrase.replace(Regex("[aeiouAEIOU]")) {
        when (it.value) {
            "a" -> "4"
            "e" -> "3"
            "i" -> "1"
            "o" -> "0"
            "u" -> "|_|"
            "A" -> "4"
            "E" -> "3"
            "I" -> "1"
            "O" -> "0"
            "U" -> "|_|"
            else -> it.value
        }
    }


