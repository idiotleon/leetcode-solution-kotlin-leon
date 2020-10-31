/**
 * https://leetcode.com/problems/stone-game-iii/
 *
 * Time Complexity:     O(`totalStones`)
 * Space Complexity:    O(`totalStones`)
 *
 * `dfs(i, ...)`, the max relative score the current player can get if starting the game from the i-th stone
 *      max(sum(stoneValues[i: i + k]) - dfs(i + k, ...)), 1 <= k <= 3
 *
 * References:
 *  https://zxi.mytechroad.com/blog/game-theory/leetcode-1406-stone-game-iii/
 */
package com.zea7ot.leetcode.lvl4.lc1406

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    private companion object {
        private const val ALICE = "Alice"
        private const val BOB = "Bob"
        private const val TIE = "Tie"
    }

    fun stoneGameIII(stoneValues: IntArray): String {
        val totalStones = stoneValues.size
        val memo = Array<Int?>(totalStones) { null }

        val score = dfs(0, stoneValues, memo)

        return when {
            score == 0 -> TIE
            score < 0 -> BOB
            else -> ALICE
        }
    }

    private fun dfs(i: Int,
                    stoneValues: IntArray,
                    memo: Array<Int?>): Int {
        val totalStones = stoneValues.size
        if (i >= totalStones) return 0

        memo[i]?.let { return it }

        var sum = 0
        var maxScore = memo[i] ?: Int.MIN_VALUE
        for (j in 0 until 3) {
            if (i + j >= totalStones) break
            sum += stoneValues[i + j]
            maxScore = maxOf(maxScore, sum - dfs(i + j + 1, stoneValues, memo))
        }

        memo[i] = maxScore
        return maxScore
    }
}