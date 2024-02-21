class Solution {
    fun removeStars(s: String): String {
        val result = StringBuilder()
        for(i in s){
            if(i == '*'){
                result.deleteCharAt(result.length - 1)
            }
            else{
                result.append(i)
            }
        }
        return result.toString()
    }
}