package src.leetcodescala

object CustomSortString791 {
  def customSortString(S: String, T: String): String = {
    val numInT = new Array[Int](26)
    T.foreach(ch => numInT(ch - 'a') += 1)
    val res = new StringBuilder()
    val charInS = new Array[Int](26)
    S.foreach{ch =>
      charInS(ch - 'a') = 1
      for (i <- 0 until numInT(ch - 'a')) {
        res += ch
      }
    }

    for (i <- 0 until 26) {
      if (charInS(i) == 0) {
        for (j <- 0 until numInT(i)) {
          res += (i+97).toChar
        }
      }
    }

    return res.toString()
  }
}
