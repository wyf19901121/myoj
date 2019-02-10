package src.leetcodescala

object MaximumBinaryTree654 {
  class TreeNode(var _value: Int) {
    var value: Int = _value
    var left: TreeNode = null
    var right: TreeNode = null
  }

  def constructMaximumBinaryTree(nums: Array[Int]): TreeNode = {
    if (nums == null || nums.length == 0)
      return null

    val maxNum: Int = nums.max
    val maxIndex: Int = nums.indexOf(maxNum)

    val root = new TreeNode(maxNum)
    root.left = constructMaximumBinaryTree(nums.slice(0, maxIndex))
    root.right = constructMaximumBinaryTree(nums.slice(maxIndex+1, nums.length))

    return root
  }
}
