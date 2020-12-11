/**
 * https://leetcode.com/problems/minimum-cost-to-cut-a-stick/
 *
 * Time Complexity:     O(`n` ^ 3)
 * Space Complexity:    O(`n` ^ 2)
 *
 * References:
 *  https://leetcode.com/problems/minimum-cost-to-cut-a-stick/discuss/780920/Java-Detailed-Explanation-DFS%2BMemo-Top-Down-DP
 */
package com.zea7ot.leetcode.lvl4.lc1547

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSMemo1 {
    fun minCost(n: Int, cuts: IntArray): Int {
        cuts.sort()
        val memo = HashMap<String, Int>()

        return dfs(0, n, cuts, memo)
    }

    private fun dfs(lo: Int, hi: Int, cuts: IntArray, memo: HashMap<String, Int>): Int {
        val hash = "$lo#$hi"
        memo[hash]?.let { return it }

        var minCost = Int.MAX_VALUE
        for (idx in cuts.indices) {
            if (cuts[idx] <= lo || cuts[idx] >= hi) continue

            val cost = hi - lo
            minCost = minOf(minCost,
                    dfs(lo, cuts[idx], cuts, memo) + cost + dfs(cuts[idx], hi, cuts, memo))
        }

        if (minCost == Int.MAX_VALUE) minCost = 0
        memo[hash] = minCost
        return minCost
    }
}