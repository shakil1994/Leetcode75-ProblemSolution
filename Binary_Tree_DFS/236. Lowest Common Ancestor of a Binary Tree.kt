/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if(root == null || root == p || root == q){
            return root
        }

        // Recursively search in the left and right subtrees
        val leftLCA = lowestCommonAncestor(root.left, p, q)
        val rightLCA = lowestCommonAncestor(root.right, p, q)

        // If both p and q are found in different subtrees, the current root is the LCA
        return if(leftLCA != null && rightLCA != null){
            root
        }
        else{
            // Otherwise, return the non-null LCA (either left or right)
            leftLCA ?: rightLCA
        }
    }
}