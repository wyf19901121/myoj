package src.leetcodescala

object WaterandJugProblem365 {
  def canMeasureWater(x: Int, y: Int, z: Int): Boolean = {
    if (z == 0)
      return true
    if (x == 0)
      return y == z
    if (y == 0)
      return x == z
    return x + y >= z && z % gcd(x, y) == 0
  }
  def gcd(x:Int, y:Int): Int = {
    if (x < y) {
      return gcd(y, x)
    }

    if (y == 0) {
      return 0
    }

    return if (x % y == 0) y else gcd(y, x%y)
  }
}
