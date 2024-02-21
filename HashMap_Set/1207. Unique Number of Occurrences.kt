class Solution {
    fun uniqueOccurrences(arr: IntArray): Boolean {
        val occurrenceCount = mutableMapOf<Int, Int>()
        //val uniqueOccurrences = HashSet<Int>()

        for(num in arr){
            occurrenceCount[num] = occurrenceCount.getOrDefault(num, 0) + 1
        }
        val uniqueOccurrences = HashSet(occurrenceCount.values)
        return occurrenceCount.size == uniqueOccurrences.size
        // for(count in occurrenceCount.values){
        //     if(!uniqueOccurrences.add(count)){
        //         return false
        //     }
        // }
        // return true
    }
}