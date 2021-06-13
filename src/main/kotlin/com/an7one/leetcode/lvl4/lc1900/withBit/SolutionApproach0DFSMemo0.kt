/**
 * https://leetcode.com/problems/the-earliest-and-latest-rounds-where-players-compete/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * !This is !!!NOT!!! yet correct solution!
 *
 * Reference:
 *  https://leetcode.com/problems/the-earliest-and-latest-rounds-where-players-compete/discuss/1268539/Recursion/972645
 *  https://leetcode.com/problems/the-earliest-and-latest-rounds-where-players-compete/discuss/1268539/Recursion
 */
package com.an7one.leetcode.lvl4.lc1900.withBit

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSMemo0 {
    private var earliest = Int.MAX_VALUE
    private var latest = Int.MIN_VALUE

    fun earliestAndLatest(n: Int, firstPlayer: Int, secondPlayer: Int): IntArray {
        dfs(0, 1, 1, n, n, minOf(firstPlayer, secondPlayer), maxOf(firstPlayer, secondPlayer))

        return intArrayOf(earliest, latest)
    }

    private fun dfs(deadMask: Int, round: Int, lo: Int, hi: Int, n: Int, firstPlayer: Int, secondPlayer: Int) {
        var lo = lo
        var hi = hi

        while (lo < hi && (deadMask and (1 shl lo)) == 1) ++lo
        while (lo < hi && (deadMask and (1 shl hi)) == 1) --hi

        when {
            lo >= hi -> dfs(deadMask, round + 1, 1, n, n, firstPlayer, secondPlayer)

            lo == firstPlayer && hi == secondPlayer -> {
                earliest = minOf(earliest, round)
                latest = maxOf(latest, round)
            }

            else -> {
                if (lo != firstPlayer && lo != secondPlayer)
                    dfs(deadMask or (1 shl lo), round, lo + 1, hi - 1, n, firstPlayer, secondPlayer)

                if (hi != firstPlayer && hi != secondPlayer)
                    dfs(deadMask or (1 shl hi), round, lo + 1, hi - 1, n, firstPlayer, secondPlayer)
            }
        }
    }
}