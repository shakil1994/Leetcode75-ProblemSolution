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
    fun longestZigZag(root: TreeNode?): Int {
        val result = intArrayOf(0)
        dfs(root, true, 0, result)
        return result[0]
    }

    private fun dfs(node: TreeNode?, isLeft: Boolean, length: Int, result: IntArray) {
        if (node == null) {
            return
        }

        // Update the result with the maximum length encountered so far
        result[0] = maxOf(result[0], length)

        // Recursively explore the next node in the zigzag path based on the current direction
        if (isLeft) {
            dfs(node.left, false, length + 1, result)  // Explore left subtree with direction false (right)
            dfs(node.right, true, 1, result)  // Reset and explore right subtree with direction true (left)
        } else {
            dfs(node.right, true, length + 1, result)  // Explore right subtree with direction true (left)
            dfs(node.left, false, 1, result)  // Reset and explore left subtree with direction false (right)
        }
    }
}