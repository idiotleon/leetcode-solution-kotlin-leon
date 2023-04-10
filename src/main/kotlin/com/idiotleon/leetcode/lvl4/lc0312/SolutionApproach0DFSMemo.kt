package com.idiotleon.leetcode.lvl4.lc0312

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/burst-balloons/
 *
 * Time Complexity:     O(`nNums` ^ 3)
 * Space Complexity:    O(`nNums` ^ 2)
 *
 * Reference:
 * http://zxi.mytechroad.com/blog/dynamic-programming/leetcode-312-burst-balloons/
 * https://youtu.be/z3hu2Be92UA
 */
@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    fun maxCoins(nums: IntArray): Int {
        val nNums = nums.size
        val nPadded = nNums + 2

        val padded = IntArray(nPadded) { idx ->
            when (idx) {
                0 -> 1
                nNums + 1 -> 1
                else -> nums[idx - 1]
            }
        }

        val memo = Array(nPadded) { IntArray(nPadded) { 0 } }
        return dfs(1, nNums, padded, memo)
    }

    private fun dfs(lo: Int, hi: Int, padded: IntArray, memo: Array<IntArray>): Int {
        if (lo > hi) return 0
        if (lo == hi) return padded[lo - 1] * padded[lo] * padded[lo + 1]
        if (memo[lo][hi] > 0) return memo[lo][hi]

        var maxCoins = 0
        for (k in lo..hi) {
            maxCoins = maxOf(
                maxCoins, dfs(lo, k - 1, padded, memo) + padded[lo - 1] * padded[k] * padded[hi + 1] + dfs(
                    k + 1, hi, padded, memo
                )
            )
        }

        memo[lo][hi] = maxCoins
        return maxCoins
    }
}