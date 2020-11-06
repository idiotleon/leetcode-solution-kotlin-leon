/**
 * https://leetcode.com/problems/divisor-game/
 *
 * Time Complexity:     O(`N`)
 * Space Complexity:    O(`N`)
 *
 * `dp[i]`, result of the i-th round for the player who starts firstly
 *
 * References:
 *  https://leetcode.com/problems/divisor-game/discuss/274581/Share-my-stupid-Java-dp-solution
 */
package com.zea7ot.leetcode.lvl2.lc1025

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun divisorGame(N: Int): Boolean {
        val dp = BooleanArray(N + 1) { false }

        outer@ for (hi in 1..N) {
            inner@ for (lo in 1 until hi) {
                if (hi % lo == 0 && !dp[hi - lo]) {
                    dp[hi] = true
                    break@inner
                }
            }
        }

        return dp[N]
    }
}