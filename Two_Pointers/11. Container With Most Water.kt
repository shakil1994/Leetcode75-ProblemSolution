class Solution {
    fun maxArea(height: IntArray): Int {
        var maxArea = 0
        var left = 0
        var right = height.size - 1

        while(left < right){
            val h = minOf(height[left], height[right])
            val w = right - left

            maxArea = maxOf(maxArea, h * w)

            if(height[left] < height[right]){
                left++
            }
            else {
                right--
            }
        }
        return maxArea
    }
}