class Solution {
    fun nearestExit(maze: Array<CharArray>, entrance: IntArray): Int {
        val rows = maze.size
        val cols = maze[0].size
        val directions = arrayOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(-1, 0))

        val queue: Queue<IntArray> = LinkedList()
        queue.offer(entrance)
        maze[entrance[0]][entrance[1]] = '+'

        var steps = 0

        while(queue.isNotEmpty()){
            val size = queue.size
            for(i in 0 until size){
                val current = queue.poll()

                for(dir in directions){
                    val newRow = current[0] + dir[0]
                    val newCol = current[1] + dir[1]

                    if(newRow in 0 until rows && newCol in 0 until cols && maze[newRow][newCol] == '.'){
                        if(newRow == 0 || newRow == rows - 1 || newCol == 0 || newCol == cols - 1){
                            return steps + 1
                        }
                        maze[newRow][newCol] = '+'
                        queue.offer(intArrayOf(newRow, newCol))
                    }
                }
            }
            steps++
        }
        return -1 // No exit found
    }
}