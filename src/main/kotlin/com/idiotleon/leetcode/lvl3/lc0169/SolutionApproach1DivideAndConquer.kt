/**
 * @author" Leon
 * https://leetcode.com/problems/majority-element/
 *
 * Time Complexity:     O(`nNums` * lg(`nNums`))
 * Space Complexity:    O(lg(`nNums`))
 *
 * Reference:
 * https://youtu.be/SWr4cSY2fCk?t=366
 */
package com.idiotleon.leetcode.lvl3.lc0169

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/majority-element/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
@Suppress(UNUSED)
private class SolutionApproach1DivideAndConquer {
    fun majorityElement(nums: IntArray): Int {
        val nNums = nums.size

        return divide(0, nNums - 1, nums)
    }

    private fun divide(lo: Int, hi: Int, nums: IntArray): Int {
        if (lo == hi) return nums[lo]
        val mid = lo + (hi - lo) / 2

        val leftRes = divide(lo, mid, nums)
        val rightRes = divide(mid + 1, hi, nums)
        if (leftRes == rightRes) return leftRes
        val leftCnt = conquer(lo, hi, leftRes, nums)
        val rightCnt = conquer(lo, hi, rightRes, nums)

        return if (leftCnt > rightCnt) leftRes else rightRes
    }

    private fun conquer(lo: Int, hi: Int, target: Int, nums: IntArray): Int {
        var count = 0
        for (idx in lo..hi) {
            if (nums[idx] == target) {
                ++count
            }
        }

        return count
    }
}