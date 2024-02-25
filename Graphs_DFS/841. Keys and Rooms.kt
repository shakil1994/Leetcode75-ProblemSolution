class Solution {
    fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
        val visited = BooleanArray(rooms.size)
        dfs(rooms, 0, visited)
        return visited.all{it}
    }

    private fun dfs(rooms: List<List<Int>>, room: Int, visited: BooleanArray){
        visited[room] = true
        for(key in rooms[room]){
            if(!visited[key]){
                dfs(rooms, key, visited)
            }
        }
    }
}