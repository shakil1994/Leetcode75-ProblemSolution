class Solution {
    fun letterCombinations(digits: String): List<String> {
        val result = mutableListOf<String>()

        if(digits.isNotEmpty()){
            generateCombinations("", digits, 0, result)
        }

        return result
    }

    private fun generateCombinations(current: String, digits: String, index: Int, result: MutableList<String>){
        if(index == digits.length){
            result.add(current)
            return
        }

        val letters = getLetters(digits[index])
        for(letter in letters){
            generateCombinations(current + letter, digits, index + 1, result)
        }
    }

    private fun getLetters(digit: Char): String{
        return when(digit){
            '2' -> "abc"
            '3' -> "def"
            '4' -> "ghi"
            '5' -> "jkl"
            '6' -> "mno"
            '7' -> "pqrs"
            '8' -> "tuv"
            '9' -> "wxyz"
            else -> ""
        }
    }
}