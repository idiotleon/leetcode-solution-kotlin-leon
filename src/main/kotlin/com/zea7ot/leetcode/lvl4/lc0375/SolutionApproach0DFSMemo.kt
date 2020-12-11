/**
 * https://leetcode.com/problems/guess-number-higher-or-lower-ii/
 *
 * Time Complexity:     O(`n` ^ 3)
 * Space Complexity:    O(`n` ^ 2) + O(`n`)
 *
 * References:
 *  https://leetcode.com/problems/guess-number-higher-or-lower-ii/discuss/84764/Simple-DP-solution-with-explanation~~/89353
 *  https://leetcode.com/problems/guess-number-higher-or-lower-ii/discuss/84764/Simple-DP-solution-with-explanation~~
 *  https://leetcode.com/problems/guess-number-higher-or-lower-ii/discuss/84778/Recursion-%2B-Memization
 */
package com.zea7ot.leetcode.lvl4.lc0375

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    fun getMoneyAmount(n: Int): Int {
        val memo = Array(n + 1) { Array<Int?>(n + 1) { null } }
        return dfs(1, n, memo)
    }

    private fun dfs(lo: Int, hi: Int, memo: Array<Array<Int?>>): Int {
        if (lo >= hi) return 0
        memo[lo][hi]?.let { return it }

        var globalMinCost = Int.MAX_VALUE
        for (k in lo..hi) {
            val localMaxCost = k + maxOf(dfs(lo, k - 1, memo), dfs(k + 1, hi, memo))
            globalMinCost = minOf(globalMinCost, localMaxCost)
        }
        memo[lo][hi] = globalMinCost
        return globalMinCost
    }
}