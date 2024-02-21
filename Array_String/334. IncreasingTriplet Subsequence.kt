class Solution {
    fun increasingTriplet(nums: IntArray): Boolean {
        var small = Int.MAX_VALUE
        var nextSmall = Int.MAX_VALUE

        for (num in nums) {
            if (num > nextSmall) return true

            if (num < small) small = num
            else if (num > small && num < nextSmall) nextSmall = num
        }

        return false
    }
}