/** Coordinate это класс данных, представляющий систему координат перемещения
 * игрока в мире игры.*/
data class Coordinate(val x: Int, val y: Int) {
    val isInBounds = x >= 0 && y >=0


}