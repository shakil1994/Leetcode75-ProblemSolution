class Solution {
    fun mergeAlternately(word1: String, word2: String): String {
        val result = StringBuilder(word1.length + word2.length)
        
        var i = 0
        var j = 0
        
        while (i < word1.length && j < word2.length) {
            result.append(word1[i++])
            result.append(word2[j++])
        }
        
        // If one of the strings is longer, append the remaining characters
        while (i < word1.length) {
            result.append(word1[i++])
        }
        
        while (j < word2.length) {
            result.append(word2[j++])
        }
        return result.toString()
    }
}