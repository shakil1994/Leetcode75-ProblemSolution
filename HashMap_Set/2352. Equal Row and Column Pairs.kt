class Solution {
    fun equalPairs(grid: Array<IntArray>): Int {
        val rowCount = grid.size
        var colCount = 0
        
        for(row in 0 until rowCount){
            for(col in 0 until rowCount){
                var equalPairsCount = 0
                while(equalPairsCount < rowCount && grid[row][equalPairsCount] == grid[equalPairsCount][col]){
                    equalPairsCount++
                }
                if(equalPairsCount == rowCount){
                    colCount++
                }
            }
        }
        return colCount
    }
}