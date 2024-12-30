package com.idiotleon.leetcode.lvl3.lc2466

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/count-ways-to-build-good-strings/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * Reference:
 * https://leetcode.com/problems/count-ways-to-build-good-strings/solutions/3518124/python3-c-java-easy-and-understand-dp/
 */
@Suppress(UNUSED)
class Solution0DP1Dimen {
    private companion object {
        private const val MOD = 1e9.toInt() + 7
    }

    fun countGoodStrings(low: Int, high: Int, zero: Int, one: Int): Int {
        val dp = IntArray(1 + high) { 0 }.also {
            it[0] = 1
        }

        for (num in minOf(zero, one)..high) {
            if (num >= zero) {
                dp[num] = (dp[num] + dp[num - zero]) % MOD
            }
            if (num >= one) {
                dp[num] = (dp[num] + dp[num - one]) % MOD
            }
        }
        var sum = 0
        for (num in low..high) {
            sum = (sum + dp[num]) % MOD
        }
        return sum
    }
}