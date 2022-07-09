package com.an7one.leetcode.lvl4.lc1547

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/minimum-cost-to-cut-a-stick/
 *
 * Time Complexity:     O(`n` ^ 3)
 * Space Complexity:    O(`n` ^ 2)
 *
 * Reference:
 * https://leetcode.com/problems/minimum-cost-to-cut-a-stick/discuss/781074/JavaC++Python-Merge-Stones/648523
 * https://leetcode.com/problems/minimum-cost-to-cut-a-stick/discuss/780920/Java-Detailed-Explanation-DFS%2BMemo-Top-Down-DP
 */
@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    fun minCost(n: Int, cuts: IntArray): Int {
        val nCuts = cuts.size

        val padded = ArrayList<Int>().also {
            for (cut in cuts) it.add(cut)
            it.add(0)
            it.add(n)
            it.sort()
        }

        val nPaddedCuts = padded.size

        val memo = Array(nPaddedCuts) { Array<Int?>(nPaddedCuts) { null } }
        return dfs(0, nCuts + 1, padded, memo)
    }

    private fun dfs(lo: Int, hi: Int, padded: List<Int>, memo: Array<Array<Int?>>): Int {
        if (hi <= lo + 1) return 0
        memo[lo][hi]?.let { return it }

        // can be omitted
//        if (hi == lo + 2) {
//            memo[lo][hi] = padded[hi] - padded[lo]
//            return memo[lo][hi]!!
//        }

        var minCost = Int.MAX_VALUE
        for (k in lo + 1 until hi) {
            minCost = minOf(minCost, dfs(lo, k, padded, memo) + dfs(k, hi, padded, memo))
        }

        minCost += padded[hi] - padded[lo]
        memo[lo][hi] = minCost
        return minCost
    }
}