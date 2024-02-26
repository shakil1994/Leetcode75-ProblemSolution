class Solution {
    fun findPeakElement(nums: IntArray): Int {
        // var left = 0
        // var right = nums.size - 1

        // while (left < right) {
        //     val mid = left + (right - left) / 2

        //     if (nums[mid] > nums[mid + 1]) {
        //         // Peak element is in the left half
        //         right = mid
        //     } else {
        //         // Peak element is in the right half
        //         left = mid + 1
        //     }
        // }

        // return left

        var left = 0
        var right = nums.size - 1;
        
        while (left < right) {
            var mid = (left + right) / 2;
            if (nums[mid] > nums[mid + 1])
                // Peak element is in the left half
                right = mid;
            else
                // Peak element is in the right half
                left = mid + 1;
        }
        return left;
    }
}