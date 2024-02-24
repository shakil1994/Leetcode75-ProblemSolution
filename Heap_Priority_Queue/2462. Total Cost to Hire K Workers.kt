class Solution {
    fun totalCost(costs: IntArray, k: Int, candidates: Int): Long {

        var totalCost: Long = 0
        var i = 0
        var j = costs.size - 1
        val leftHeap = PriorityQueue<Int>()
        val rightHeap = PriorityQueue<Int>()

        repeat(k) {
            while (leftHeap.size < candidates && i <= j)
                leftHeap.offer(costs[i++])
            while (rightHeap.size < candidates && i <= j)
                rightHeap.offer(costs[j--])

            totalCost += when {
                leftHeap.isEmpty() -> rightHeap.poll().toLong()
                rightHeap.isEmpty() -> leftHeap.poll().toLong()
                leftHeap.peek() <= rightHeap.peek() -> leftHeap.poll().toLong()
                else -> rightHeap.poll().toLong()
            }
        }

        return totalCost
    }
}