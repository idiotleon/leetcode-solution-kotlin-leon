/**
 * https://leetcode.com/problems/handshakes-that-dont-cross/
 *
 * Time Complexity:     O(`nNums` ^ 2)
 * Space Complexity:    O(`nNums`)
 *
 * References:
 *  https://leetcode.com/problems/handshakes-that-dont-cross/discuss/430539/JavaC%2B%2BPython-DP-and-O(N)
 */
package com.an7one.leetcode.lvl4.lc1259

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    private companion object {
        private const val MOD = 1e9.toLong() + 7
    }

    fun numberOfWays(nPeople: Int): Int {
        val dp = LongArray(nPeople / 2 + 1)
        dp[0] = 1

        for (hi in 1..nPeople / 2) {
            for (lo in 0 until hi) {
                dp[hi] += (dp[lo] * dp[hi - 1 - lo]) % MOD
                dp[hi] %= MOD
            }
        }

        return dp[nPeople / 2].toInt()
    }
}