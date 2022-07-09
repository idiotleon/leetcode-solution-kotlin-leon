package com.an7one.leetcode.lvl4.lc1595

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/minimum-cost-to-connect-two-groups-of-points/
 *
 * Time Complexity:     O(`nCosts` * (2 ^ `nPoints`) * `nPoints`)
 * Space Complexity:    O(`nCosts` * (2 ^ `nPoints`))
 *
 * Reference:
 * https://leetcode.com/problems/minimum-cost-to-connect-two-groups-of-points/discuss/855041/C++Python-DP-using-mask/703424
 * https://leetcode.com/problems/minimum-cost-to-connect-two-groups-of-points/discuss/855041/C%2B%2BPython-DP-using-mask
 * https://leetcode.com/problems/minimum-cost-to-connect-two-groups-of-points/discuss/855425/Java-bottom-up-DP-with-bit-mask/705851
 * https://leetcode.com/problems/minimum-cost-to-connect-two-groups-of-points/discuss/855188/Python-Clean-DP-+-Bitmask-solution-with-explaination/736365
 */
@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    fun connectTwoGroups(costs: List<List<Int>>): Int {
        val nCosts = costs.size
        val nPoints = costs[0].size

        val right = IntArray(nPoints) { Int.MAX_VALUE }

        for (row in costs.indices) {
            for (col in costs[row].indices) {
                right[col] = minOf(right[col], costs[row][col])
            }
        }

        val memo = Array(nCosts + 1) { Array<Int?>(1 shl nPoints) { null } }

        return dfs(0, 0, right, costs, memo)
    }

    private fun dfs(cur: Int, curState: Int, right: IntArray, costs: List<List<Int>>, memo: Array<Array<Int?>>): Int {
        val nCosts = costs.size
        memo[cur][curState]?.let { return it }

        var minCost = 0
        if (cur < nCosts) {
            minCost = Int.MAX_VALUE
            for (idxCost in costs[cur].indices) {
                minCost =
                    minOf(minCost, costs[cur][idxCost] + dfs(cur + 1, curState or (1 shl idxCost), right, costs, memo))
            }
        } else {
            for (idxCost in costs[0].indices) {
                if ((curState and (1 shl idxCost)) == 0) {
                    minCost += right[idxCost]
                }
            }
        }

        memo[cur][curState] = minCost
        return minCost
    }
}