class Solution {
    fun countBits(n: Int): IntArray {
        val result = IntArray(n + 1)

        for(i in 1..n){
            // To count the bits of a number, use the count of bits in its rightmost part (i & 1)
            // and add the count of bits for the remaining part (i >> 1)
            result[i] = result[i shr 1] + (i and 1)
        }
        return result
    }
}