class Player {
    var name = "adler"
        get() = field.capitalize()
        private set(value) {
            field = value.trim()
        }

    fun castFireball(numFireballs: Int = 2) =
        println("A glass of Fireball springs into existence. (x$numFireballs)")

    /* //castFireball
     private fun castFireball(numFireballs: Int, playerName: String) {
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

         println(*//*"A glass of Fireball springs into existence. " +*//*
            "$playerName stupefied on $stupefyingResult%, he " +
                    "drunk x$numFireballs fireballs. \nHis condition $condition."
        )
    }*/

}