/**
 * https://leetcode.com/problems/stone-game-iii/
 *
 * Time Complexity:     O(`totalStones`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/stone-game-iii/discuss/564260/JavaC%2B%2BPython-DP-O(1)-Space
 */
package com.zea7ot.leetcode.lvl4.lc1406

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP0Dimen {
    private companion object {
        private const val ALICE = "Alice"
        private const val BOB = "Bob"

        private const val TIE = "Tie"
    }

    fun stoneGameIII(stoneValues: IntArray): String {
        val nStones = stoneValues.size
        val dp = IntArray(4) { 0 }
        for (curTurn in nStones - 1 downTo 0) {
            dp[curTurn % 4] = Int.MIN_VALUE
            var sum = 0
            for (curPick in 0 until 3) {
                if (curTurn + curPick >= nStones) break

                sum += stoneValues[curTurn + curPick]
                val nextTurn = curTurn + curPick + 1
                dp[curTurn % 4] = maxOf(dp[curTurn % 4], sum - dp[nextTurn % 4])
            }
        }

        return when {
            dp[0] > 0 -> ALICE
            dp[0] < 0 -> BOB
            else -> TIE
        }
    }
}