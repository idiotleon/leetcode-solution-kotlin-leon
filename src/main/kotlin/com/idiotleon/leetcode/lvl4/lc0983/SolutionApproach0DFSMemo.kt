/**
 * https://leetcode.com/problems/minimum-cost-for-tickets/
 *
 * Time Complexity:     O(`nDays`)
 * Space Complexity:    O(`nDays`)
 *
 * References:
 *  https://leetcode.com/problems/minimum-cost-for-tickets/discuss/227321/Top-down-DP-Logical-Thinking
 */
package com.idiotleon.leetcode.lvl4.lc0983

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    private companion object {
        private const val BY_DAY = 1
        private const val BY_WEEK = 7
        private const val BY_MONTH = 30
    }

    fun minCostTickets(days: IntArray, costs: IntArray): Int {
        val nDays = days.size
        val memo = Array<Int?>(nDays) { null }
        return dfs(0, days, costs, memo)
    }

    private fun dfs(idxDay: Int, days: IntArray, costs: IntArray, memo: Array<Int?>): Int {
        val nDays = days.size
        if (idxDay == nDays) return 0

        memo[idxDay]?.let { return it }

        val byDay = costs[0] + dfs(getNextTravelDay(idxDay, BY_DAY, days), days, costs, memo)
        val byWeek = costs[1] + dfs(getNextTravelDay(idxDay, BY_WEEK, days), days, costs, memo)
        val byMonth = costs[2] + dfs(getNextTravelDay(idxDay, BY_MONTH, days), days, costs, memo)
        val minCost = minOf(byDay, byWeek, byMonth)
        memo[idxDay] = minCost
        return minCost
    }

    private fun getNextTravelDay(idxDay: Int, byDuration: Int, days: IntArray): Int {
        val nDays = days.size

        val endIdxDay = days[idxDay] + byDuration - 1
        var idx = idxDay

        while (idx < nDays && days[idx] <= endIdxDay) ++idx

        return idx
    }
}