class Solution {
    fun calcEquation(equations: List<List<String>>, values: DoubleArray, queries: List<List<String>>): DoubleArray {
        val graph = mutableMapOf<String, MutableMap<String, Double>>()

        for(i in equations.indices){
            val (a, b) = equations[i]
            val value = values[i]

            graph.computeIfAbsent(a) {mutableMapOf()}[b] = value
            graph.computeIfAbsent(b) {mutableMapOf()}[a] = 1 / value
        }

        val results = DoubleArray(queries.size) { -1.0}
        for(i in queries.indices){
            val(start, end) = queries[i]
            results[i] = dfs(start, end, mutableSetOf(), graph)
        }
        return results
    }

    private fun dfs(start: String, end: String, visited: MutableSet<String>, graph: Map<String, Map<String, Double>>): Double{
        if(!graph.containsKey(start) || !graph.containsKey(end))
            return -1.0
        if(start == end)
            return 1.0
        visited.add(start)

        for((neighbor, value) in graph[start]!!){
            if(neighbor !in visited){
                val subResult = dfs(neighbor, end, visited, graph)
                if(subResult != -1.0)
                    return value * subResult
            }
        }
        visited.remove(start)
        return -1.0
    }
}