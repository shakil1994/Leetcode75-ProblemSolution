class Solution {
    fun reverseVowels(s: String): String {
        val vowels = setOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
        val charArray = s.toCharArray()

        var i = 0
        var j = charArray.size - 1

        while(i < j){
            while(i < j && charArray[i].toLowerCase() !in vowels){
                i++
            }

            while(i < j && charArray[j].toLowerCase() !in vowels){
                j--
            }

            // Swap vowels at positions i and j
            val temp = charArray[i]
            charArray[i] = charArray[j]
            charArray[j] = temp

            i++
            j--
        }

        return String(charArray)
    }
}