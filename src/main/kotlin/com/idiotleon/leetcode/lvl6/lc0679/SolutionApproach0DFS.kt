package com.idiotleon.leetcode.lvl6.lc0679

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import kotlin.math.abs

/**
 * @author: Leon
 * https://leetcode.com/problems/24-game/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * Reference:
 * https://leetcode.com/problems/24-game/discuss/107673/JAVA-Easy-to-understand.-Backtracking./750045
 */
@Suppress(UNUSED)
class SolutionApproach0DFS {
    private companion object {
        private const val EPSILON = 0.01
    }

    fun judgePoint24(nums: IntArray): Boolean {
        val cards = ArrayList<Double>().also {
            for (num in nums) it.add(num.toDouble())
        }

        return dfs(cards)
    }

    private fun dfs(cards: ArrayList<Double>): Boolean {
        val totalCards = cards.size
        // only 1 card left
        if (totalCards == 1) {
            if (abs(cards[0] - 24.0) < 0.001) return true
            return false
        }

        // to take two cards
        for (lo in cards.indices) {
            for (hi in lo + 1 until totalCards) {
                for (card in compute(cards[lo], cards[hi])) {
                    // to create a new ArrayList
                    val nextRound = arrayListOf(card)

                    for (k in cards.indices) {
                        if (k == lo || k == hi) continue
                        nextRound.add(cards[k])
                    }

                    if (dfs(nextRound)) return true
                }
            }
        }

        return false
    }

    private fun compute(a: Double, b: Double) = doubleArrayOf(a + b, a - b, b - a, a * b, a / b, b / a)
}