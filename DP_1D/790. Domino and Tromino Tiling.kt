class Solution {
    fun numTilings(n: Int): Int {
        if (n == 1) return 1
        if (n == 2) return 2
        val dp = Array(n + 1) { LongArray(3) }
        dp[1][0] = 1
        dp[2][0] = 2
        dp[2][1] = 1
        dp[2][2] = 1
        val kmod = 1_000_000_007
        for (i in 3..n) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 2][0] + dp[i - 1][1] + dp[i - 1][2]) % kmod
            dp[i][1] = (dp[i - 2][0] + dp[i - 1][2]) % kmod
            dp[i][2] = (dp[i - 2][0] + dp[i - 1][1]) % kmod
        }
        return dp[n][0].toInt()
    }
}