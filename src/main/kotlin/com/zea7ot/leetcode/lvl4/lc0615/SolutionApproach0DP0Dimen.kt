/**
 * https://leetcode.com/problems/4-keys-keyboard/
 *
 * Time Complexity:     O(`n`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/4-keys-keyboard/discuss/105980/Java-4-lines-recursion-with-step-by-step-explanation-to-derive-DP/108426
 *  https://leetcode.com/problems/4-keys-keyboard/discuss/105997/Mathematical-proof-of-the-O(N)-solution
 */
package com.zea7ot.leetcode.lvl4.lc0615

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP0Dimen {
    fun maxA(n: Int): Int {
        val dp = IntArray(7) { 0 }

        for (i in 1..n) {
            dp[0] = i

            for (k in 6 downTo 2 + 1) {
                dp[0] = maxOf(dp[0], dp[k] * (k - 1))
            }

            for (k in 6 downTo 0 + 1) {
                dp[k] = dp[k - 1]
            }
        }

        return dp[0]
    }
}