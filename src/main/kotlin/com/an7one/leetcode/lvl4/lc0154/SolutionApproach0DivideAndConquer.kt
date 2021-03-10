/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 *
 * Time Complexity:     O(lg(N)), O(N) in the worst case
 * Space Complexity:    O(lg(N))
 *
 * References:
 *  http://zxi.mytechroad.com/blog/divide-and-conquer/leetcode-154-find-minimum-in-rotated-sorted-array-ii/
 *  https://www.youtube.com/watch?v=aCb1zKMimDQ
 */
package com.an7one.leetcode.lvl4.lc0154

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DivideAndConquer {
    fun findMin(nums: IntArray): Int {
        val totalNums = nums.size

        return dfs(0, totalNums - 1, nums)
    }

    private fun dfs(lo: Int, hi: Int, nums: IntArray): Int {
        if (lo + 1 >= hi) return minOf(nums[lo], nums[hi])

        if (nums[lo] < nums[hi]) return nums[lo]

        val mid = lo + (hi - lo) / 2

        return minOf(dfs(lo, mid - 1, nums), dfs(mid, hi, nums))
    }
}