class Solution {
    private var i = 0
    fun decodeString(s: String): String {
        val sb = StringBuilder()

        while(i < s.length && s[i] != ']'){
            if(s[i].isDigit()){
                var k = 0
                while(i < s.length && s[i].isDigit()){
                    k = k * 10 + (s[i++] - '0')
                }
                i++ // '['
                val decodedString = decodeString(s)
                i++ // ']'
                repeat(k){
                    sb.append(decodedString)
                }
            }
            else{
                sb.append(s[i++])
            }
        }
        return sb.toString()
    }
}