package com.bignerdranch.nyethack

fun main() {

    val player = Player()

    player.castFireball(6)

    val auraColor = player.auraColor()

    val healthStatus = player.healthStatus()

    printPlayerStatus(player)

}

//game.Player Status
private fun printPlayerStatus(player: Player) {
    val statusFormattingString = "(HP: ${player.healthPoints}) \n(Aura: ${(player.auraColor())})" +
            "\n(Race: ${(player.race)})" +
            "\n${player.name} ${player.healthStatus()}"
    println(statusFormattingString)
}


