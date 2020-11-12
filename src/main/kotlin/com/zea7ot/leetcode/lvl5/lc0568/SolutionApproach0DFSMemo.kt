/**
 * https://leetcode.com/problems/maximum-vacation-days/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/maximum-vacation-days/discuss/159704/Naive-DFS-greater-DFS-w-memo-greater-2D-DP-greater-1D-DP
 */
package com.zea7ot.leetcode.lvl5.lc0568

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    fun maxVacationDays(flights: Array<IntArray>, days: Array<IntArray>): Int {
        val nCities = days.size
        val nWeeks = days[0].size

        val memo = Array(nCities) { Array<Int?>(nWeeks) { null } }
        return dfs(0, 0, flights, days, memo)
    }

    private fun dfs(curWeek: Int, curCity: Int, flights: Array<IntArray>, days: Array<IntArray>, memo: Array<Array<Int?>>): Int {
        val nWeeks = days[0].size
        val nCities = days.size

        if (curWeek == nWeeks) return 0

        memo[curCity][curWeek]?.let { return it }

        var max = 0
        for (idx in days.indices) {
            if (curCity == idx || flights[curCity][idx] == 1) {
                max = maxOf(max, days[idx][curWeek] + dfs(curWeek + 1, idx, flights, days, memo))
            }
        }

        memo[curCity][curWeek] = max
        return max
    }
}