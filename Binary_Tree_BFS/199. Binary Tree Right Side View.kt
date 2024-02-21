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
    fun rightSideView(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()

        if(root == null){
            return result
        }

        val queue: Queue<TreeNode> = LinkedList()
        queue.offer(root)

        while(queue.isNotEmpty()){
            val size = queue.size

            for(i in 0 until size){
                val node = queue.poll()

                // Keep track of the rightmost node at each level
                if(i == size - 1){
                    result.add(node.`val`)
                }

                node.left?.let{queue.offer(it)}
                node.right?.let{queue.offer(it)}
            }
        }
        return result
    }
}