class Solution {
    fun closeStrings(word1: String, word2: String): Boolean {
       
        if(word1.length != word2.length) return false

        val freqCount1 = getCharCountArray(word1)
        val freqCount2 = getCharCountArray(word2)

        var x = 0
        for(i in freqCount1.indices) {
            if ((freqCount1[i] > 0).xor(freqCount2[i] > 0)) {
                return false
            }
        }
        Arrays.sort(freqCount1)
        Arrays.sort(freqCount2)
            
        return freqCount1.contentEquals(freqCount2)
    }
    fun getCharCountArray(s: String): IntArray {
        val a = IntArray(26) {0}
        s.forEach { i ->
            a[i-'a']++
        }
        return a
    }
}