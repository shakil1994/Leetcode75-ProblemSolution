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
    // Variable to keep track of the count of valid paths
    var countOfPaths = 0
    fun pathSum(root: TreeNode?, targetSum: Int): Int {
        // Check if the root is null, return 0 if true
        if (root == null) {
            return 0
        }
        // Call the recursive helper function to count paths
        countPaths(root, targetSum, 0)

        // Explore paths in the left and right subtrees
        pathSum(root.left, targetSum)
        pathSum(root.right, targetSum)

        // Return the total count of valid paths
        return countOfPaths
    }

    // Recursive helper function to count paths
    private fun countPaths(root: TreeNode?, sum: Int, currentSum: Long) {
        // Base case: If the current node is null, return without further recursion
        if (root == null) {
            return
        }
        // Calculate the updated sum along the current path
        val updatedCurrentSum = currentSum + root.`val`

        // Check if the updated sum equals the target sum
        if (updatedCurrentSum == sum.toLong()) {
            // Increment the count of valid paths
            countOfPaths++
        }

        // Recursively explore paths in the left and right subtrees
        countPaths(root.left, sum, updatedCurrentSum)
        countPaths(root.right, sum, updatedCurrentSum)
    } 
}