/**
 * https://leetcode.com/problems/dice-roll-simulation/
 *
 * Time Complexity:     O(`n` * 6)
 * Space Complexity:    O(`n` * 6)
 *
 * `dp[roll][dice]`, the amount of sequences ending with `dice`(face value)
 *
 * initialization: dp[1][*] = 1
 *
 * base:
 *  dp[roll][dice] = sum(dp[roll - 1])
 *
 * remove invalid ones:
 *  k = roll - rollMax[dice]
 *  if k == 1:
 *      dp[roll][dice] -= 1
 *  if k > 1:
 *      dp[roll][dice] -= (sums[k - 1] - dp[k - 1][dice])
 *
 *  answer: sum(dp[`n`])
 *
 * References:
 *  https://youtu.be/3JOZcD-BRLE?t=838
 *  https://zxi.mytechroad.com/blog/dynamic-programming/leetcode-1223-dice-roll-simulation/
 */
package com.zea7ot.leetcode.lvl4.lc1223

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen1 {
    private companion object {
        private const val MOD = 1e9.toInt() + 7
        private const val FACE_VALUE_RANGE = 6
    }

    fun dieSimulator(n: Int, rollMax: IntArray): Int {
        // `dp[i][j]`, number of sequences ending with `j` after `i` rolls
        val dp = Array(n + 1) { IntArray(FACE_VALUE_RANGE) { 0 } }
        val sums = IntArray(n + 1) { 0 } // sum[i] = sum(dp[i])
        for (dice in 0 until FACE_VALUE_RANGE) {
            dp[1][dice] = 1 // 1 step, 1 dice, 1 way
            sums[1] += dp[1][dice]
        }

        for (roll in 2..n) {
            for (dice in 0 until FACE_VALUE_RANGE) {
                val k = roll - rollMax[dice]
                val invalid = if (k <= 1) maxOf(k, 0) else sums[k - 1] - dp[k - 1][dice]
                dp[roll][dice] = ((sums[roll - 1] - invalid) % MOD + MOD) % MOD
                sums[roll] = (sums[roll] + dp[roll][dice]) % MOD
            }
        }

        return sums[n]
    }
}