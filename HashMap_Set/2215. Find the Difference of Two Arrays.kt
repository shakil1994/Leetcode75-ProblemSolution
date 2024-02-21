class Solution {
    fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
        val set1 = nums1.toSet()
        val set2 = nums2.toSet()

        val uniqueInNums1 = mutableListOf<Int>()
        val uniqueInNums2 = mutableListOf<Int>()

        for (num1 in set1) {
            if (!set2.contains(num1)) {
                uniqueInNums1.add(num1)
            }
        }

        for (num2 in set2) {
            if (!set1.contains(num2)) {
                uniqueInNums2.add(num2)
            }
        }

        return listOf(uniqueInNums1, uniqueInNums2)
    }
}