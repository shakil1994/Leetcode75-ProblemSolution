class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val ans = IntArray(nums.size)
        var temp = 1
        var revIdx = nums.size - 1
        for ((idx, n) in nums.withIndex()) {
            ans[idx] = temp
            temp *= n
        }

        temp = 1
        while (revIdx >= 0) {
            ans[revIdx] *= temp
            temp *= nums[revIdx]
            revIdx--
        }
        return ans
    }
}