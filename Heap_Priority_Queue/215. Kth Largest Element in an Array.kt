class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        //return quickSelect(nums, 0, nums.size - 1, nums.size - k)
        val bucket = IntArray(20001)
        nums.forEach { bucket[it + 10000]++ }

        var i = 20000
        var k = k
        while (i >= 0 && k > 0) {
            while (bucket[i] > 0 && k > 0) {
                bucket[i]--
                k--
            }
            i--
        }

        return i - 9999
    }

    // private fun quickSelect(nums: IntArray, low: Int, high: Int, targetIndex: Int): Int{
    //     val pivotIndex = partition(nums, low, high)

    //     return when{
    //         pivotIndex == targetIndex -> nums[pivotIndex]
    //         pivotIndex < targetIndex -> quickSelect(nums, pivotIndex + 1, high, targetIndex)
    //         else -> quickSelect(nums, low, pivotIndex - 1, targetIndex)
    //     }
    // }

    // private fun partition(nums: IntArray, low: Int, high: Int): Int{
    //     val pivot = nums[high]
    //     var i = low

    //     for(j in low until high){
    //         if(nums[j] < pivot){
    //             swap(nums, i, j)
    //             i++
    //         }
    //     }
    //     swap(nums, i, high)
    //     return i
    // }

    // private fun swap(nums: IntArray, i: Int, j: Int){
    //     val temp = nums[i]
    //     nums[i] = nums[j]
    //     nums[j] = temp
    // }
}