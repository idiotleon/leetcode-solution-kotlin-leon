/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 *
 * Time Complexity:     O(lg(`nNums`))
 *  T(N) = T(N / 2) + O(1) = T(lg(N)), NOT T(N) = 2 * T(N / 2) = O(N)
 *
 * Space Complexity:    O(lg(`nNums`))
 *
 * References:
 *  http://zxi.mytechroad.com/blog/divide-and-conquer/leetcode-153-find-minimum-in-rotated-sorted-array/
 *  https://www.youtube.com/watch?v=P4r7mF1Jd50
 */
package com.zea7ot.leetcode.lvl3.lc0153

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

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