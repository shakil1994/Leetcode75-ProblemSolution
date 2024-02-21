class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val result = IntArray(temperatures.size)
        val stack = mutableListOf<Int>()

        for(i in temperatures.indices){
            while(stack.isNotEmpty() && temperatures[i] > temperatures[stack.last()]){
                val prevIndex = stack.removeAt(stack.size - 1)
                result[prevIndex] = i - prevIndex
            }
            stack.add(i)
        }
        return result
    }
}