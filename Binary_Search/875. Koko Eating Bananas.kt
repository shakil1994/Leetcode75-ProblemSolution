class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var left = 1
        var right = piles.maxOrNull() ?: 1

        while (left < right) {
            val mid = left + (right - left) / 2

            if (canEatAll(piles, mid, h)) {
                // Try to minimize the eating speed
                right = mid
            } else {
                // Eating speed is too slow, need to increase it
                left = mid + 1
            }
        }

        return left
    }
    private fun canEatAll(piles: IntArray, speed: Int, h: Int): Boolean {
        var hours = 0

        for (pile in piles) {
            hours += (pile + speed - 1) / speed
        }

        return hours <= h
    }
}