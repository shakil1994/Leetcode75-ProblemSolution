class Solution {
    fun successfulPairs(spells: IntArray, potions: IntArray, success: Long): IntArray {
        val potionsCount = IntArray(100_001)
        for (potion in potions) {
            ++potionsCount[potion]
        }
        for (potion in 100_000 - 1 downTo 1) {
            potionsCount[potion] += potionsCount[potion + 1]
        }

        val result = IntArray(spells.size)

        val pairs = success - 1
        for (i in result.indices) {
            val neededPotion = pairs / spells[i] + 1
            if (neededPotion <= 100_000L) {
                result[i] = potionsCount[neededPotion.toInt()]
            }
        }

        return result
    }
}