class Solution {
    fun moveZeroes(nums: IntArray): Unit {
        var nonZeroIndex = 0
        nums.forEach{ it -> 
            if(it != 0){
                nums[nonZeroIndex] = it
                nonZeroIndex++
            }
        }
        while(nonZeroIndex < nums.size){
            nums[nonZeroIndex] = 0
            nonZeroIndex++
        }
    }
}