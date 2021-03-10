/**
 * @author: Leon
 * https://leetcode.com/problems/best-team-with-no-conflicts/
 *
 * Time Complexity:     O(`totalPlayers` ^ 2) + O(`totalPlayers` * lg(`totalPlayers`)) ~ O(`totalPlayers` ^ 2)
 * Space Complexity:    O(`totalPlayers`)
 */
package com.an7one.leetcode.lvl3.lc1626

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun bestTeamScore(scores: IntArray, ages: IntArray): Int {
        val totalPlayers = scores.size
        val players = Array(totalPlayers) { idx -> Player(ages[idx], scores[idx]) }

        players.sortWith(compareBy({ it.age }, { it.score }))

        val dp = IntArray(totalPlayers) { 0 }

        var maxScore = dp[0]
        for (hi in 0 until totalPlayers) {
            dp[hi] = players[hi].score

            for (lo in hi - 1 downTo 0) {
                // conflicts
                if (players[lo].score > players[hi].score) continue
                dp[hi] = maxOf(dp[hi], dp[lo] + players[hi].score)
            }

            maxScore = maxOf(maxScore, dp[hi])
        }

        return maxScore
    }

    private data class Player(val age: Int, val score: Int)
}