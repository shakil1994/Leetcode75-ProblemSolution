class RecentCounter() {
    private val requests = LinkedList<Int>()
    fun ping(t: Int): Int {
        // Remove requests plder than 3000 milliseconds
        while(!requests.isEmpty() && requests.first + 3000 < t){
            requests.removeFirst()
        }
        // Add the current request timestamp
        requests.addLast(t)

        // Return the number of recent requests
        return requests.size
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * var obj = RecentCounter()
 * var param_1 = obj.ping(t)
 */