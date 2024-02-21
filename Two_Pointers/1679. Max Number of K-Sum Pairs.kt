class Solution {
    fun maxOperations(nums: IntArray, k: Int): Int {
        val numOccurrences = mutableMapOf<Int, Int>()
        var count = 0

        for (num in nums){
            val complement = k - num
            if(numOccurrences.getOrDefault(complement, 0) > 0){
                count++
                numOccurrences[complement] = numOccurrences[complement]!! - 1
            }
            else {
                numOccurrences[num] = numOccurrences.getOrDefault(num, 0) + 1
            }
        }
        return count
    }
}