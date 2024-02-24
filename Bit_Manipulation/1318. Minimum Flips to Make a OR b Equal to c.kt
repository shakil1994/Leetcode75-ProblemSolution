class Solution {
    fun minFlips(a: Int, b: Int, c: Int): Int {
        var flips = 0
        var aCopy = a
        var bCopy = b
        var cCopy = c

        while(aCopy > 0 || bCopy > 0 || cCopy > 0){
            val bitA = aCopy and 1
            val bitB = bCopy and 1
            val bitC = cCopy and 1

            if(bitC == 0){
                // If the current bit in c is 0, check if either bit in a or b is 1, then flip that bit
                if(bitA == 1) flips++
                if(bitB == 1) flips++
            }
            else {
                // If the current bit in c is 1, check if both bits in a and b are 0, then flip one of them
                if(bitA == 0 && bitB == 0) flips++
            }
            aCopy = aCopy shr 1
            bCopy = bCopy shr 1
            cCopy = cCopy shr 1
        }
        return flips
    }
}