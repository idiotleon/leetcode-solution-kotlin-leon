/**
 * https://leetcode.com/problems/stone-game-iv/
 *
 * Time Complexity:     ?O(`n`)
 * Space Complexity:    ?O(`n`)
 *
 * References:
 *  https://leetcode.com/problems/stone-game-iv/discuss/730490/Java-or-Heavily-Commented-or-Subproblems-Visualised
 */
package com.zea7ot.leetcode.lvl4.lc1510

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    fun winnerSquareGame(n: Int): Boolean {
        val memo = Array<Boolean?>(n + 1) { null }

        return dfs(n, memo)
    }

    private fun dfs(n: Int, memo: Array<Boolean?>): Boolean {
        memo[n]?.let { return it }

        var canReach = false
        var move = 1
        while (n - move * move >= 0) {
            if (n - move * move == 0) {
                canReach = true
                break
            } else {
                canReach = canReach or !dfs(n - move * move, memo)
            }

            ++move
        }

        memo[n] = canReach
        return canReach
    }
}