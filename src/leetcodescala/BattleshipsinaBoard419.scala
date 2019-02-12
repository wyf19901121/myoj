package src.leetcodescala

object BattleshipsinaBoard419 {
  def countBattleships(board: Array[Array[Char]]): Int = {
    var count: Int = 0

    for (i <- board.indices) {
      for (j <- board(0).indices) {
        if (board(i)(j) == 'X' && (i == 0 || board(i-1)(j) == '.') && (j == 0 || board(i)(j-1) == '.')) {
          count += 1
        }
      }
    }

    return count
  }
}
