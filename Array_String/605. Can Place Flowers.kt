class Solution {
    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        var count = 0
        var i = 0

        while(i < flowerbed.size){
            if (flowerbed[i] == 0 &&
                (i == 0 || flowerbed[i - 1] == 0) &&
                (i == flowerbed.size - 1 || flowerbed[i + 1] == 0)){
                flowerbed[i] = 1
                count++
                i += 2
            }
            else{
                i++
            }
        }
        return count >= n
    }
}