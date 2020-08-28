package com.bignerdranch.nyethack

import Room
import TownSquare

fun main() {

    Game.play()
}

object Game {
    private val player = Player("Adler")
    private var currentRoom: Room = TownSquare()

    init {
        println("Welcome, Adventurer.")
        player.castFireball(6)
    }

    fun play() {
        while (true) {
            println(currentRoom.description())
            println(currentRoom.load())

            printPlayerStatus(player)

            print("> Enter your command: ")
            println(GameInput(readLine()).processCommand())
        }
    }

    //game.Player Status
    private fun printPlayerStatus(player: Player) {
        val statusFormattingString = "(HP: ${player.healthPoints})" +
                "\n(Aura: ${(player.auraColor())})" +
                "\n(Race: ${(player.race)})" +
                "\n${player.name} ${player.healthStatus()}"
        println(statusFormattingString)
    }

    /*Данный класс вложен и объявлен приватным, так как он непосредственно
    связан с объектом и не должен быть доступным откуда-то еще*/
    private class GameInput(arg: String?) {

        /* Мы объявили 2 свойства: первое для команды, а второе для аргумента.
        * Вызвали split(), которая разбивает входную строку по символу пробела,
        * а затем getOrElse, чтобы получить второй элемент списка, если такой элемент
        * не существует, getOrElse вернет пустую строку.*/
        private val input = arg ?: ""
        val command = input.split(" ")[0]
        val argument = input.split(" ").getOrElse(1, { "" })

        /*processCommand должна возвращать результат when(), который
        зависит от введеной пользователем команды*/
        fun processCommand() = when (command.toLowerCase()) {
            else -> commandNotFound()
        }

        /*любой качественный белый список команд начинается с реализации
        обработки недопустимого ввода*/
        private fun commandNotFound() = "I'm not quite sure what you're trying" +
                "to do!"


    }
}

