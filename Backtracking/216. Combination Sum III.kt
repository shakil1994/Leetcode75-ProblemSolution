class Solution {
    fun combinationSum3(k: Int, n: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val currentList = mutableListOf<Int>()

        backtracking(1, k, n, currentList, result)

        return result
    }

    private fun backtracking(start: Int, k: Int, target: Int, currentList: MutableList<Int>, result: MutableList<List<Int>>){
        if(k == 0 && target == 0){
            result.add(currentList.toList())
            return
        }

        for(i in start..9){
            currentList.add(i)
            backtracking(i + 1, k - 1, target - i, currentList, result)
            currentList.removeAt(currentList.size - 1)
        }
    }
}