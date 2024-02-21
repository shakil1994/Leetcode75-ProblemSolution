class Solution {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        if(intervals.isEmpty()) return 0

        // Sort intervals based on their end coordinates
        intervals.sortBy {it[1]}

        var nonOverlapCount = 1
        var end = intervals[0][1]

        for(i in 1 until intervals.size){
            // If the current interval doesn't overlap with the previous one, update the end coordinate 
            if(intervals[i][0] >= end){
                nonOverlapCount++
                end = intervals[i][1]
            }
        }
        // The number of intervals to be removed is equal to the total number of intervals minus the non-overlapping count.
        return intervals.size - nonOverlapCount
    }
}