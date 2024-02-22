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
    fun pathSum(root: TreeNode?, targetSum: Int): Int {
        if(root == null){
            return 0
        }

        return countPaths(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum)
    }

    private fun countPaths(node: TreeNode?, targetSum: Int): Int{
        if(node == null){
            return 0
        }

        val remainingSum = targetSum - node.`val`
        val pathsFromCurrentNode = if (remainingSum == 0) 1 else 0

        return pathsFromCurrentNode + countPaths(node.left, remainingSum) + countPaths(node.right, remainingSum)
    }
}