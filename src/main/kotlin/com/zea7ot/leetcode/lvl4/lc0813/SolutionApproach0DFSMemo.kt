/**
 * https://leetcode.com/problems/largest-sum-of-averages/
 *
 * Time Complexity:     O(`K` * (`totalNums` ^ 2))
 * Space Complexity:    O(`K` * `totalNums`) + O(`totalNums`)
 *
 * References:
 *  https://leetcode.com/problems/largest-sum-of-averages/discuss/122739/C%2B%2BJavaPython-Easy-Understood-Solution-with-Explanation
 */
package com.zea7ot.leetcode.lvl4.lc0813

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    fun largestSumOfAverages(nums: IntArray, K: Int): Double {
        val totalNums = nums.size

        val memo = Array(totalNums + 1) { DoubleArray(K + 1) { 0.0 } }
        var sum = 0.0
        for (idx in 0 until totalNums) {
            sum += nums[idx]
            memo[idx + 1][1] = sum / (idx + 1)
        }

        return dfs(totalNums, K, nums, memo)
    }

    private fun dfs(n: Int, k: Int, nums: IntArray, memo: Array<DoubleArray>): Double {
        if (memo[n][k] > 0) return memo[n][k]

        if (n < k) return 0.0

        var sum = 0.0
        for (idx in n - 1 downTo 0) {
            sum += nums[idx]
            memo[n][k] = maxOf(memo[n][k], dfs(idx, k - 1, nums, memo) + sum / (n - idx))
        }

        return memo[n][k]
    }
}