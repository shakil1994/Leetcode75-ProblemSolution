class Solution {
    fun largestAltitude(gain: IntArray): Int {
        var maxAltitude = 0
        var currentAltitide = 0
        
        for(altitudeGain in gain){
            currentAltitide += altitudeGain
            maxAltitude = Math.max(maxAltitude, currentAltitide)
        }

        return maxAltitude
    }
}