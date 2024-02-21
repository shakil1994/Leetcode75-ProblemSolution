class Solution {
    fun asteroidCollision(asteroids: IntArray): IntArray {
        val stack = mutableListOf<Int>()

        for(asteroid in asteroids){
            handleCollision(asteroid, stack)
        }

        return stack.toIntArray()
    }

    private fun handleCollision(newAsteroid: Int, stack: MutableList<Int>){
        while(stack.isNotEmpty() && newAsteroid < 0 && stack.last() > 0){
            val prevAsteroid = stack.removeAt(stack.size - 1)
            val result = prevAsteroid + newAsteroid

            if(result == 0){
                // Both asteroids destroy each other
                return
            }
            else if(result > 0){
                // New asteroid id destroyed
                stack.add(prevAsteroid)
                return
            }
            // Continue checking with the next asteroid in the stack
        }
        // No collision occured or new asteriod survives
        stack.add(newAsteroid)
    }
}