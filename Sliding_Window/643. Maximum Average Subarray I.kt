class Solution {
    fun findMaxAverage(nums: IntArray, k: Int): Double {
        var sum = 0
        for (i in 0 until k){
            sum += nums[i]
        }

        var maxAverage = sum.toDouble() / k.toDouble()
        for(i in k until nums.size){
            sum += nums[i] - nums[i - k]
            maxAverage = maxOf(maxAverage, sum.toDouble() / k.toDouble())
        }
        return maxAverage
    }
}