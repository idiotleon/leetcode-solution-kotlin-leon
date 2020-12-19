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

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    private companion object {
        private const val ALICE = "Alice"
        private const val BOB = "Bob"
        private const val TIE = "Tie"
    }

    fun stoneGameIII(stoneValues: IntArray): String {
        val nStones = stoneValues.size
        val memo = Array<Int?>(nStones) { null }

        val score = dfs(0, stoneValues, memo)

        return when {
            score > 0 -> ALICE
            score < 0 -> BOB
            else -> TIE
        }
    }

    private fun dfs(curTurn: Int, stoneValues: IntArray, memo: Array<Int?>): Int {
        val nStones = stoneValues.size
        if (curTurn >= nStones) return 0

        memo[curTurn]?.let { return it }

        var sum = 0
        var maxScore = Int.MIN_VALUE
        for (curPick in 0 until 3) {
            if (curTurn + curPick >= nStones) break

            sum += stoneValues[curTurn + curPick]
            val nextTurn = curTurn + curPick + 1
            maxScore = maxOf(maxScore, sum - dfs(nextTurn, stoneValues, memo))
        }

        memo[curTurn] = maxScore
        return maxScore
    }
}