/**
 * https://leetcode.com/problems/number-of-ways-to-reorder-array-to-get-same-bst/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/number-of-ways-to-reorder-array-to-get-same-bst/discuss/819413/Didn't-see-any-Java-solution-here-because-nobody-knows-how-to-mod/676800
 */
package com.zea7ot.leetcode.lvl4.lc1569

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSMemo {
    private companion object {
        private const val MOD = 1e9.toInt() + 7
    }

    fun numOfWays(nums: IntArray): Int {
        val nNums = nums.size
        val memo = Array(nNums) { Array<Long?>(nNums) { null } }
        return dfs(1, nNums, nums, memo).toInt() - 1
    }

    private fun dfs(lo: Int, hi: Int,
                    nums: IntArray,
                    memo: Array<Array<Long?>>): Long {
        if (lo > hi) return 1L

        var idx = 0
        while (nums[idx] < lo || nums[idx] > hi) ++idx
        val pivot = nums[idx]
        var total: Long = getTotal(pivot - lo, hi - pivot, memo)
        total = total * dfs(lo, pivot - 1, nums, memo) % MOD
        total = total * dfs(pivot + 1, hi, nums, memo) % MOD
        return total
    }

    private fun getTotal(i: Int, j: Int, memo: Array<Array<Long?>>): Long {
        memo[i][j]?.let { return it }

        if (j == 0 || i == 0) return 1

        memo[i][j] = (getTotal(i - 1, j, memo) + getTotal(i, j - 1, memo)) % MOD
        return memo[i][j]!!
    }
}