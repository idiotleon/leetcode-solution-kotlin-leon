/**
 * https://leetcode.com/problems/minimum-score-triangulation-of-polygon/
 *
 * Time Complexity:     O(`nNums` ^ 3)
 * Space Complexity:    O(`nNums` ^ 2)
 *
 * References:
 *  https://leetcode.com/problems/minimum-score-triangulation-of-polygon/discuss/286753/C%2B%2B-with-picture
 *  https://leetcode.com/problems/minimum-score-triangulation-of-polygon/discuss/286705/JavaC%2B%2BPython-DP
 */
package com.zea7ot.leetcode.lvl4.lc1039

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    fun minScoreTriangulation(nums: IntArray): Int {
        val nNums = nums.size
        val memo = Array(nNums) { Array<Int?>(nNums) { null } }

        return dfs(0, nNums - 1, nums, memo)
    }

    private fun dfs(lo: Int, hi: Int,
                    nums: IntArray,
                    memo: Array<Array<Int?>>): Int {
        memo[lo][hi]?.let { return it }
        if (hi - lo < 2) return 0

        var minScore = Int.MAX_VALUE
        for (k in lo + 1 until hi) {
            minScore = minOf(minScore,
                    dfs(lo, k, nums, memo) + nums[lo] * nums[k] * nums[hi] + dfs(k, hi, nums, memo))
        }

        memo[lo][hi] = minScore
        return minScore
    }
}