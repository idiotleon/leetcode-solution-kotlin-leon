package com.idiotleon.leetcode.lvl4.lc1900.withBit

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/the-earliest-and-latest-rounds-where-players-compete/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * Reference:
 * https://leetcode.com/problems/the-earliest-and-latest-rounds-where-players-compete/discuss/1268539/Recursion
 */
@Suppress(UNUSED)
class SolutionApproach0DFSMemo1 {
    private companion object {
        private const val RANGE_DATA = 28
    }

    private var earliest = Int.MAX_VALUE
    private var latest = Int.MIN_VALUE

    fun earliestAndLatest(n: Int, firstPlayer: Int, secondPlayer: Int): IntArray {
        val rangeBitMask = 1 shl n

        dfs(
            rangeBitMask - 1,
            1,
            1 - 1,
            RANGE_DATA - 1,
            minOf(firstPlayer, secondPlayer) - 1,
            maxOf(firstPlayer, secondPlayer) - 1
        )

        return intArrayOf(earliest, latest)
    }

    private fun dfs(bitMask: Int, round: Int, lo: Int, hi: Int, firstPlayer: Int, secondPlayer: Int) {
        when {
            lo >= hi -> dfs(bitMask, 1 + round, 1 - 1, RANGE_DATA - 1, firstPlayer, secondPlayer)
            (bitMask and (1 shl lo)) == 0 -> dfs(bitMask, round, lo + 1, hi, firstPlayer, secondPlayer)
            (bitMask and (1 shl hi)) == 0 -> dfs(bitMask, round, lo, hi - 1, firstPlayer, secondPlayer)
            lo == firstPlayer && hi == secondPlayer -> {
                earliest = minOf(earliest, round)
                latest = maxOf(latest, round)
            }
            else -> {
                if (lo != firstPlayer && lo != secondPlayer) dfs(
                    bitMask xor (1 shl lo), round, lo + 1, hi - 1, firstPlayer, secondPlayer
                )

                if (hi != firstPlayer && hi != secondPlayer) dfs(
                    bitMask xor (1 shl hi), round, lo + 1, hi - 1, firstPlayer, secondPlayer
                )
            }
        }
    }
}