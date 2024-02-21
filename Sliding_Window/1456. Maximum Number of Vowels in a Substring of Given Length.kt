class Solution {
    fun maxVowels(s: String, k: Int): Int {
        val vowels = setOf('a', 'e', 'i', 'o', 'u')
        var maxVowelCount = 0
        var currentVowelCount = 0
        // Initialize vowel count for the first substring of length k
        for(i in 0 until k){
            if (s[i] in vowels){
                currentVowelCount++
            }
        }
        maxVowelCount = currentVowelCount
        // Iterate through the string using sliding window
        for(i in k until s.length){
            if(s[i] in vowels){
                currentVowelCount++
            }
            if(s[i - k] in vowels){
                currentVowelCount--
            }
            maxVowelCount = maxOf(maxVowelCount, currentVowelCount)
        }
        return maxVowelCount
    }
}