package com.an7one.leetcode.lvl3.lc0153

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 *
 * Time Complexity:     O(lg(`nNums`))
 *  T(N) = T(N / 2) + O(1) = T(lg(N)), NOT T(N) = 2 * T(N / 2) = O(N)
 *
 * Space Complexity:    O(lg(`nNums`))
 *
 * Reference:
 * http://zxi.mytechroad.com/blog/divide-and-conquer/leetcode-153-find-minimum-in-rotated-sorted-array/
 * https://youtu.be/P4r7mF1Jd50
 */
@Suppress(UNUSED)
class SolutionApproach0DivideAndConquer {
    fun findMin(nums: IntArray): Int {
        val nNums = nums.size

        return findMin(0, nNums - 1, nums)
    }

    private fun findMin(lo: Int, hi: Int, nums: IntArray): Int {
        if (lo + 1 >= hi) return minOf(nums[lo], nums[hi])

        if (nums[lo] < nums[hi]) return nums[lo]

        val mid = lo + (hi - lo) / 2
        return minOf(findMin(lo, mid, nums), findMin(mid + 1, hi, nums))
    }
}