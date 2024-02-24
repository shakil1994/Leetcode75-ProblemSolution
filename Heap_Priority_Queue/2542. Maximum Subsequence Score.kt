class Solution {
    // fun maxScore(nums1: IntArray, nums2: IntArray, k: Int): Long {
    //     var result = 0L
    //     var sum = 0L
    //     val priorityQueue = PriorityQueue<Int>()

    //     // (nums2[i], nums1[i]) sorted by nums2[i] in descending order.
    //     val prefixSum = Array(nums1.size){
    //         Pair(nums2[it], nums1[it])
    //     }
    //     prefixSum.sortWith(compareByDescending{it.first})

    //     for(i in prefixSum){
    //         val num2 = i.first
    //         val num1 = i.second
    //         priorityQueue.offer(num1)
    //         sum += num1
    //         if(priorityQueue.size > k){
    //             sum -= priorityQueue.poll()
    //         }
    //         if(priorityQueue.size == k){
    //             result = maxOf(result, sum * num2)
    //         }
    //     }
    //     return result
    // }
    class Node(
        val idx: Int,
        val value: Int,
    )

    private val comp = Comparator<Node> { n1, n2 ->
        when {
            n1.value < n2.value -> -1
            n1.value == n2.value -> 0
            else -> 1
        }
    }

    fun maxScore(nums1: IntArray, nums2: IntArray, k: Int): Long {
        val minHeap = PriorityQueue<Node>(comp)
        val maxHeap = PriorityQueue<Node> { n1, n2 -> comp.compare(n2, n1) }

        for (i in 0..nums1.lastIndex) {
            maxHeap.add(Node(i, nums1[i]))
        }

        var sum = 0L
        repeat(k) {
            val top = maxHeap.poll()
            sum += top.value
            minHeap.add(Node(top.idx, nums2[top.idx]))
        }

        var ans = sum * minHeap.peek().value

        while (maxHeap.isNotEmpty()) {
            val min = minHeap.poll()
            sum -= nums1[min.idx]

            val nextTop = maxHeap.poll()
            sum += nextTop.value
            minHeap.add(Node(nextTop.idx, nums2[nextTop.idx]))

            ans = maxOf(ans, sum * minHeap.peek().value)
        }

        return ans
    }
}