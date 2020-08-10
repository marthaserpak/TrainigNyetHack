package com.bignerdranch.nyethack

class Player {

    var name = "adler"
        get() = field.capitalize()
        private set(value) {
            field = value.trim()
        }

    val healthPoints = 100
    val isBlessed = true
    private val isImmortal = true

    val race = "ali"
    val fraction = when (race) {
        "orc" -> "Free people of Rolling Hills."
        "human" -> "Free people of Rolling Hills."
        else -> "Aliens from Space."
    }

    //Health Status
    fun healthStatus() =
        when (healthPoints) {
            100 -> if (isImmortal) {
                "is immortal!"
            } else "is in excellent condition"
            in 90..99 -> "has a few scratches."
            in 75..89 -> if (isBlessed) {
                "has some minor wounds, but is healing quickly!"
            } else "has some minor wounds."
            in 15..74 -> "looks pretty hurt."
            else -> "is in awful condition!"
        }

    //Aura
    fun auraColor(): String {
        val karma = (Math.pow(Math.random(), (110 - healthPoints) / 100.0) *
                20).toInt()
        val auraVisible = isBlessed && healthPoints > 50 || isImmortal
        return when (karma) {
            in 0..5 -> {
                "Red"
            }
            in 6..10 -> {
                "Orange"
            }
            in 11..15 -> {
                "Purple"
            }
            else -> "Green"
        }
    }

    /*fun castFireball(numFireballs: Int = 2) =
        println("A glass of Fireball springs into existence. (x$numFireballs)")
*/
     //castFireball
     fun castFireball(numFireballs: Int) {
         val stupefyingResult = when (numFireballs) {
             in 1..5 -> 10..19
             in 6..8 -> 20..29
             in 9..15 -> 30..39
             in 16..20 -> 40..49
             else -> 50
         }

         val condition = when (stupefyingResult) {
             in 1..10 -> "Tipsy"
             in 11..20 -> "Sloshed"
             in 21..30 -> "Soused"
             in 31..40 -> "Stewed"
             else -> "..t0aSt3d"
         }

         println("A glass of Fireball springs into existence. " +
            "$name stupefied on $stupefyingResult%, he " +
                    "drunk x$numFireballs fireballs. \nHis condition $condition."
        )
    }

}