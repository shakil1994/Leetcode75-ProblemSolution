class Solution {
    fun minReorder(n: Int, connections: Array<IntArray>): Int {
        val graph = Array(n){mutableListOf<Int>()}

        for(connection in connections){
            val u = connection[0]
            val v = connection[1]
            graph[u].add(v)
            graph[v].add(-u) // - := u -> v
        }

        return dfs(graph, 0, -1)
    }

    private fun dfs(graph: Array<MutableList<Int>>, u: Int, parent: Int): Int {
        var change = 0

        for(v in graph[u]){
            if(Math.abs(v) == parent) continue
            if(v > 0) change++
            change += dfs(graph, Math.abs(v), u)
        }
        return change
    }
}