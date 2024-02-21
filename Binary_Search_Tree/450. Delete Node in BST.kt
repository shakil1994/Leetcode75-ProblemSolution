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
    fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
        if(root == null){
            return null
        }

        when{
            key < root.`val` -> root.left = deleteNode(root.left, key)
            key > root.`val` -> root.right = deleteNode(root.right, key)

            else -> {
                // Node with only one child or no child
                if(root.left == null){
                    return root.right
                }
                else if(root.right == null){
                    return root.left
                }

                // Node with two children, get the in-order successor (smallest in the right subtree)
                root.`val` = findMin(root.right!!)
                // Delete the in-order successor
                root.right = deleteNode(root.right, root.`val`)
            }
        }

        return root
    }

    private fun findMin(node: TreeNode): Int{
        var current = node
        while(current.left != null){
            current = current.left!!
        }
        return current.`val`
    }
}