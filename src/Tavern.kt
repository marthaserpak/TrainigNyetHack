import  java.io.File

const val NAME_OF_TAVERN = "Taernyl's Folly"
val firstName = mutableListOf("Hanna", "Alex", "Elli")
val lastName = listOf("Wellish", "Gamilton", "Verburg")
val uniquePatrons = mutableSetOf<String>()
val menuList = File("src/data/menu.txt")
    .readText()
    .split("\n")
val patronGold = mutableMapOf<String, Double>()


fun main() {

    // Display menu of tavern
    /*menuList.forEachIndexed { index, data ->
        println("${index+1} : $data")
    }*/

    (0..5).forEach {
        val first = firstName.shuffled().first()
        val last = lastName.shuffled().first()
        val name = "$first $last"
        uniquePatrons += name
    }

    uniquePatrons.forEach{
        patronGold[it] = 6.0
    }

    var orderCount = 0
    while (orderCount <= 4) {
        placeOrder(uniquePatrons.shuffled().first(),
            menuList.shuffled().first())
        orderCount++
    }

}

fun placeOrder(patron: String, menuData: String) {
    val indexOfApostrophe = NAME_OF_TAVERN.indexOf("\'")
    val tavernMaster = NAME_OF_TAVERN.substring(0 until indexOfApostrophe)
    println("$patron speaks with $tavernMaster about their order.")

    val (type, name, price) = menuData.split(",")
    println("$patron ordered $name ($type) for $price.")

    if (name == "Dragon's Breath") {
        println("$patron exclaims ${toDragonSpeak("Ah, how delicious $name")}")
    } else println("$patron says: thank you very much for $name.")
    println()
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


