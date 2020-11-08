/**
 * https://leetcode.com/problems/palindrome-removal/
 *
 * Time Complexity:     O(`nNums` ^ 3)
 * Space Complexity:    O(`nNums` ^ 2)
 *
 * References:
 *  https://leetcode.com/problems/palindrome-removal/discuss/418835/JavaC%2B%2BPython3-DP-with-Details-Comments
 */
package com.zea7ot.leetcode.lvl4.lc1246

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    fun minimumMoves(nums: IntArray): Int {
        val nNums = nums.size
        val memo = Array(nNums) { Array<Int?>(nNums) { null } }
        return dfs(0, nNums - 1, nums, memo)
    }

    private fun dfs(lo: Int, hi: Int, nums: IntArray, memo: Array<Array<Int?>>): Int {
        if (lo > hi) return 0
        memo[lo][hi]?.let { return it }

        var minMoves = dfs(lo, hi - 1, nums, memo) + 1
        if (hi > 0 && nums[hi - 1] == nums[hi]) {
            minMoves = minOf(minMoves, dfs(lo, hi - 2, nums, memo) + 1)
        }

        for (k in lo until hi - 1) {
            if (nums[k] == nums[hi]) {
                minMoves = minOf(minMoves, dfs(lo, k - 1, nums, memo) + dfs(k + 1, hi - 1, nums, memo))
            }
        }

        memo[lo][hi] = minMoves
        return minMoves
    }
}