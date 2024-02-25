class Solution {
    fun findCircleNum(isConnected: Array<IntArray>): Int {
        val n = isConnected.size
        val visited = BooleanArray(n)
        var count = 0

        for(i in 0 until n){
            if(!visited[i]){
                dfs(isConnected, i, visited)
                count++
            }
        }
        return count
    }

    private fun dfs(isConnected: Array<IntArray>, node: Int, visited: BooleanArray){
        visited[node] = true

        for(neighbor in isConnected[node].indices){
            if(isConnected[node][neighbor] == 1 && !visited[neighbor]){
                dfs(isConnected, neighbor, visited)
            }
        }
    }
}