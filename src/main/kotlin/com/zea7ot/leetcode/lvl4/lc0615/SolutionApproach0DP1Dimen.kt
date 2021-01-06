/**
 * https://leetcode.com/problems/4-keys-keyboard/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/4-keys-keyboard/discuss/105980/Java-4-lines-recursion-with-step-by-step-explanation-to-derive-DP
 *  https://leetcode.com/problems/4-keys-keyboard/discuss/105997/Mathematical-proof-of-the-O(N)-solution
 */
package com.zea7ot.leetcode.lvl4.lc0615

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun maxA(n: Int): Int {
        val dp = IntArray(n + 1) { 0 }

        for (hi in 0..n) {
            dp[hi] = hi
            for (lo in 1..hi - 3) {
                dp[hi] = maxOf(dp[hi], dp[lo] * (hi - lo - 1))
            }
        }

        return dp[n]
    }
}