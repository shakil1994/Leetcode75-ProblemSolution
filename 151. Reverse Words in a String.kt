class Solution {
    fun reverseWords(s: String): String {
         val sb = StringBuilder()

        var l = 0
        var r = 0

        while(r <= s.length) {
            if(r == s.length || s[r] == ' ') {
                if(r - l > 0) {
                    if(sb.length > 0) {
                        sb.insert(0, ' ')
                    }
                    sb.insert(0, s.substring(l, r))
                }
                r++
                l = r
            } else {
                r++
            }
        }

        return sb.toString()
    }
}