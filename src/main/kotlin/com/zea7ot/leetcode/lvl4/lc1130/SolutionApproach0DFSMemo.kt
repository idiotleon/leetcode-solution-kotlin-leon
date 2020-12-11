/**
 * https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/
 *
 * Time Complexity:     O(`nNums` ^ 3)
 * Space Complexity:    O(`nNums` ^ 2)
 *
 * References:
 *  https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/discuss/398420/Java-DP-Solution-very-easy-to-understand
 */
package com.zea7ot.leetcode.lvl4.lc1130

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    fun mctFromLeafValues(nums: IntArray): Int {
        val nNums = nums.size
        val memo = Array(nNums) { Array<Int?>(nNums) { null } }
        return dfs(0, nNums - 1, nums, memo)
    }

    private fun dfs(lo: Int, hi: Int, nums: IntArray, memo: Array<Array<Int?>>): Int {
        if (lo == hi) return 0
        memo[lo][hi]?.let { return it }

        var minCost = Int.MAX_VALUE
        for (i in lo until hi) {
            val left = dfs(lo, i, nums, memo)
            val right = dfs(i + 1, hi, nums, memo)

            var maxLeft = 0
            var maxRight = 0

            for (j in lo..i) maxLeft = maxOf(maxLeft, nums[j])
            for (j in i + 1..hi) maxRight = maxOf(maxRight, nums[j])
            minCost = minOf(minCost, left + right + maxLeft * maxRight)
        }

        memo[lo][hi] = minCost
        return minCost
    }
}