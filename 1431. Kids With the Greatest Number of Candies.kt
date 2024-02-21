class Solution {
    fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
        var maxCandies = 0

        for(kidCandies in candies) {
            maxCandies = maxOf(kidCandies, maxCandies)
        }

         val result = mutableListOf<Boolean>()
         for(candy in candies) {
             result.add(candy + extraCandies >= maxCandies)
         }

         return result
    }
}