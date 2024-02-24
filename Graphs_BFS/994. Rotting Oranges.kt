class Solution {
    fun orangesRotting(grid: Array<IntArray>): Int {
        val rows = grid.size
        val cols = grid[0].size

        val directions = arrayOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(-1, 0))

        val queue: Queue<Pair<Int, Int>> = LinkedList()
        var freshOranges = 0
        var minutes = 0

        // Initilize the queue and count the number of fresh oranges
        for(i in 0 until rows){
            for(j in 0 until cols){
                if(grid[i][j] == 2){
                    queue.offer(Pair(i, j))
                }
                else if (grid[i][j] == 1){
                    freshOranges++
                }
            }
        }

        // Special case: No fresh oranges, return 0
        if(freshOranges == 0){
            return 0
        }

        // Perform BFS to Simutale rotting process
        while(queue.isNotEmpty()){
            val size = queue.size

            for(i in 0 until size){
                val(x, y) = queue.poll()

                for(dir in directions){
                    val newX = x + dir[0]
                    val newY = y + dir[1]

                    if(newX in 0 until rows && newY in 0 until cols && grid[newX][newY] == 1){
                        grid[newX][newY] = 2
                        freshOranges--
                        queue.offer(Pair(newX, newY))
                    }
                }
            }
            if(queue.isNotEmpty()){
                minutes++
            }
        }
        // Check if all fresh oranges are rotten
        return if(freshOranges == 0) minutes else -1
    }
}