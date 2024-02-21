class Solution {
    fun findMinArrowShots(points: Array<IntArray>): Int {
        if(points.isEmpty()) return 0

        // Sort the points based on their end coordinates
        points.sortBy {it[1]}

        var arrows = 1
        var end = points[0][1]

        for(i in 1 until points.size){
            // If the current balloon's start coordinate ig greater than the previous balloon's end coordinate,
            // We need an additional arrow and update the end coordinate.
            if(points[i][0] > end){
                arrows++
                end = points[i][1]
            }
        }
        return arrows
    }
}