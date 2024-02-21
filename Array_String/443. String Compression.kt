class Solution {
    fun compress(chars: CharArray): Int {
        if(chars.size <= 1) return chars.size

        var writeIndex = 0
        var readIndex = 0

        while(readIndex < chars.size){
            var count = 0
            val currentChar = chars[readIndex]

            while(readIndex < chars.size && chars[readIndex] == currentChar){
                readIndex++
                count++
            }
            chars[writeIndex++] = currentChar
            if(count > 1){
                for (digit in count.toString()){
                    chars[writeIndex++] = digit
                }
            }
        }
        return writeIndex
    }
}