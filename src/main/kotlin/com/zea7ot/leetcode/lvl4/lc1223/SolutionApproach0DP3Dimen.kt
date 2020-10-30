/**
 * https://leetcode.com/problems/dice-roll-simulation/
 *
 * Time Complexity:     O(`n` * 6 * 6 * 15)
 * Space Complexity:    O(`n` * 6 * 15)
 *
 * dp[i][j][k]
 *  i, length of the sequence
 *  j, face value of the last dice (current dice, the same or not)
 *  k, number of consecutive dices of the end
 *
 * Initialization:
 *  dp[1][*][1] = 1
 *
 * Transition:
 *  dp[i][j][1] = sum(dp[i - 1][p][*]), j != p
 *  dp[i][j][k + 1] = dp[i - 1][j][k], k < rollMax[j]
 *
 * Answer:
 *  sum(dp[n])
 *
 * References:
 *  https://youtu.be/3JOZcD-BRLE
 */
package com.zea7ot.leetcode.lvl4.lc1223

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP3Dimen {
    private companion object {
        private const val MOD = 1e9.toInt() + 7
        private const val MAX_ROLLS = 15
        private const val FACE_VALUE_RANGE = 6
    }

    fun dieSimulator(n: Int, rollMax: IntArray): Int {
        // `dp[i][j][k]`, number of sequences ending with `k` consecutive `j` after `i` rolls
        val dp = Array(n + 1) { Array(FACE_VALUE_RANGE) { IntArray(MAX_ROLLS + 1) { 0 } } }
        for (faceValue in 0 until FACE_VALUE_RANGE) {
            dp[1][faceValue][1] = 1 // 1 step, 1 dice, 1 way
        }

        for (roll in 2..n) {
            for (dice1 in 0 until FACE_VALUE_RANGE) {
                for (dice2 in 0 until FACE_VALUE_RANGE) {
                    for (k in 1..rollMax[dice2]) {
                        if (dice2 != dice1) { // not the same dice
                            dp[roll][dice1][1] = (dp[roll][dice1][1] + dp[roll - 1][dice2][k]) % MOD
                        } else if (k < rollMax[dice1]) { // the same dice, to make sure k + 1 <= rollMax
                            dp[roll][dice1][k + 1] = dp[roll - 1][dice1][k]
                        }
                    }
                }
            }
        }

        var ans = 0
        for (faceValue in 0 until FACE_VALUE_RANGE) {
            for (k in 1..rollMax[faceValue]) {
                ans += dp[n][faceValue][k]
                ans %= MOD
            }
        }
        return ans
    }
}