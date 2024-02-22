/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun goodNodes(root: TreeNode?): Int {
        return countGoodNodes(root, Int.MIN_VALUE)
    }

    private fun countGoodNodes(node: TreeNode?, maxSoFar: Int): Int{
        if(node == null){
            return 0
        }

        val currentMax = maxOf(maxSoFar, node.`val`)
        val leftGoodNodes = countGoodNodes(node.left, currentMax)
        val rightGoodNodes = countGoodNodes(node.right, currentMax)

        return if(node.`val` >= currentMax){
            1 + leftGoodNodes + rightGoodNodes
        }
        else {
            leftGoodNodes + rightGoodNodes
        }
    }
}