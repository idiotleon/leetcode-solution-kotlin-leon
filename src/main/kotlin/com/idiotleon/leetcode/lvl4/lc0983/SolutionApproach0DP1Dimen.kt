package com.idiotleon.leetcode.lvl4.lc0983

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/minimum-cost-for-tickets/
 *
 * Time Complexity:     O(`lastDay`)
 * Space Complexity:    O(`lastDay`)
 *
 * a bottom-up approach
 *
 * Reference:
 * https://leetcode.com/problems/minimum-cost-for-tickets/discuss/227130/Java-DP-Solution-with-detailed-comment-and-explanation
 * https://leetcode.com/problems/minimum-cost-for-tickets/discuss/226659/Two-DP-solutions-with-pictures
 */
@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    private companion object {
        private const val BY_DAY = 1
        private const val BY_WEEK = 7
        private const val BY_MONTH = 30
    }

    fun minCostTickets(days: IntArray, costs: IntArray): Int {
        val nDays = days.size

        val lastDay = days.last()
        val dp = IntArray(lastDay + 1) { 0 }
        val isTravelDay = BooleanArray(lastDay + 1)
        for (day in days) {
            isTravelDay[day] = true
        }

        for (day in 1..lastDay) {
            if (!isTravelDay[day]) {
                dp[day] = dp[day - 1]
                continue
            }

            val byDay = costs[0] + dp[day - BY_DAY]
            val byWeek = costs[1] + dp[maxOf(0, day - BY_WEEK)]
            val byMonth = costs[2] + dp[maxOf(0, day - BY_MONTH)]
            dp[day] = minOf(byDay, byWeek, byMonth)
        }

        return dp[lastDay]
    }
}