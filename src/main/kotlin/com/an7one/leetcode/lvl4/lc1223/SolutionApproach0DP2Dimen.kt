/**
 * https://leetcode.com/problems/dice-roll-simulation/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * `dp[roll][faceValue]`, the amount of distinct sequences that can be obtained when rolling `roll` times,
 *  and ending with `faceValue` face value
 *
 * References:
 *  https://leetcode.com/problems/dice-roll-simulation/discuss/403756/Java-Share-my-DP-solution/362770
 *  https://leetcode.com/problems/dice-roll-simulation/discuss/403756/Java-Share-my-DP-solution/364819
 *  https://youtu.be/3JOZcD-BRLE
 *  https://zxi.mytechroad.com/blog/dynamic-programming/leetcode-1223-dice-roll-simulation/
 */
package com.an7one.leetcode.lvl4.lc1223

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    private companion object {
        private const val MOD = 1e9.toInt() + 7
        private const val DICE_RANGE = 6
    }

    fun dieSimulator(n: Int, rollMax: IntArray): Int {
        val dp = Array(n + 1) { roll -> IntArray(DICE_RANGE + 1) { if (roll == 1) 1 else 0 } }
        dp[1][6] = DICE_RANGE

        for (roll in 2..n) {
            var total = 0
            for (faceVal in 0 until DICE_RANGE) {
                // if there is no constraint,
                // the total sequences ending with `faceVal` should be the total sequences from the previous roll
                dp[roll][faceVal] = dp[roll - 1][DICE_RANGE]

                // for xx1, only 111 is not allowed,
                // to remove 1 sequence from the previous sum
                //
                // if for the `roll`-th dice, constraint for `faceVal` is `roll` - 1,
                // meaning that at most (`roll` - 1) consecutive dices can have same number,
                // that is to say all previous numbers can be the same, except current number, so to minus one.
                if (roll - rollMax[faceVal] == 1) --dp[roll][faceVal]

                // if for the ith dice, constraint for `faceVal` is < `roll` - 1,
                // meaning that the (`roll - rollMax[faceVal] - 1`)-th number can be anything but `faceVal`(which we have already deducted in the previous step)
                if (roll - rollMax[faceVal] >= 2) { // if for the `roll`-th dice, constraint for `faceVal` is < `roll` - 1
                    // for axx1, to remove the number of a11 (211, 311, 411, 511, 611) => (..2 + ..3 + ..4 + ..5 + ..6) => (sum - ..1)
                    val reduction =
                        dp[roll - rollMax[faceVal] - 1][DICE_RANGE] - dp[roll - rollMax[faceVal] - 1][faceVal]

                    // to add one more `MOD` to prevent negative amounts/numbers
                    dp[roll][faceVal] = ((dp[roll][faceVal] - reduction) % MOD + MOD) % MOD
                }

                total = (total + dp[roll][faceVal]) % MOD
            }

            dp[roll][DICE_RANGE] = total
        }

        return dp[n][DICE_RANGE]
    }
}