fun main() {
    val playerName = "Josh"
    val healthPoints = 73
    val isImmortal = false
    val isBlessed = true

    val healthStatus = healthStatus(healthPoints, isImmortal, isBlessed)
    val auraColor = auraColor(healthPoints)

    val race = "orc"
    val fraction = when (race) {
        "orc" -> ", free people of Rolling Hills."
        "human" -> ", free people of Rolling Hills."
        else -> ", aliens from space."
    }

    printPlayerStatus(
        playerName, race, fraction, healthPoints, isImmortal, isBlessed,
        healthStatus, auraColor
    )

}

fun printPlayerStatus(
    playerName: String, race: String, fraction: String, healthPoints: Int,
    isImmortal: Boolean, isBlessed: Boolean, healthStatus: String,
    auraColor: String
) {
    val playerStatus = "$playerName is $race$fraction \nHP: $healthPoints " +
            "\nIs immortal: $isImmortal \nIsBlessed: $isBlessed" +
            "\n$playerName $healthStatus And has $auraColor aura."
    return println(playerStatus)
}

fun healthStatus(healthPoints: Int, isImmortal: Boolean, isBlessed: Boolean): String {
    return when (healthPoints) {
        100 -> if (isImmortal) "is Immortal!" else " in excellent condition!"
        in 90..99 -> if (isImmortal) "is Immortal!" else "has a few scratches"
        in 75..89 -> if (isImmortal) "is Immortal!" else if (isBlessed) " has some minor wounds, but is healing quickly!"
        else " has some minor wounds"
        in 15..74 -> if (isImmortal) "is Immortal!" else " looks pretty hurt."
        else -> if (isImmortal) "is Immortal!" else "is in awful condition!"
    }
}

fun auraColor(healthPoints: Int): String {
    val karma = (Math.pow(Math.random(), (110 - healthPoints) / 100.0) *
            20).toInt()
    return when (karma) {
        in 0..5 -> "red"
        in 6..10 -> "orange"
        in 11..15 -> "green"
        else -> "purple"
    }
}
