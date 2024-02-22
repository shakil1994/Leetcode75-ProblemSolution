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
    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
        val leafSequence1 = mutableListOf<Int>()
        val leafSequence2 = mutableListOf<Int>()

        collectLeafValues(root1, leafSequence1)
        collectLeafValues(root2, leafSequence2)

        return leafSequence1 == leafSequence2
    }

    private fun collectLeafValues(root: TreeNode?, leafSequence: MutableList<Int>){
        if(root == null){
            return
        }

        if(root.left == null && root.right == null){
            leafSequence.add(root.`val`)
        }

        collectLeafValues(root.left, leafSequence)
        collectLeafValues(root.right, leafSequence)
    }
}