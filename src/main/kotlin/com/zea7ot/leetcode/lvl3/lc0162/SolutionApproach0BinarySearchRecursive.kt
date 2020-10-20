/**
 * https://leetcode.com/problems/find-peak-element/
 *
 * Time Complexity:     O(lg(`totalNums`))
 * Space Complexity:    O(lg(`totalNums`))
 */
package com.zea7ot.leetcode.lvl3.lc0162

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BinarySearchRecursive {
    fun findPeakElement(nums: IntArray): Int {
        val totalNums = nums.size

        return dfs(0, totalNums - 1, nums)
    }

    private fun dfs(lo: Int, hi: Int, nums: IntArray): Int {
        if (lo == hi) return lo

        val mid = lo + (hi - lo) / 2
        return if (nums[mid] > nums[mid + 1]) {
            dfs(lo, mid, nums)
        } else {
            dfs(mid + 1, hi, nums)
        }
    }
}