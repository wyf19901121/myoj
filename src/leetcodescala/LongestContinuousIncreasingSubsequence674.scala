package src.leetcodescala

object LongestContinuousIncreasingSubsequence674 {
  def findLengthOfLCIS(nums: Array[Int]): Int = {
    var maxLen = 0
    var curLen = 1

    if (nums == null || nums.length == 0)
      return maxLen

    for (i <- 1 until nums.length) {
      if (nums(i) <= nums(i-1)) {
        maxLen = math.max(curLen, maxLen)
        curLen = 1
      }
      else {
        curLen += 1
      }
    }
    return math.max(maxLen, curLen)
  }
}
