/**
 * @author: Leon
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://youtu.be/SWr4cSY2fCk?t=933https://youtu.be/SWr4cSY2fCk?t=933
 */
package com.idiotleon.summary.byAlgorithm.sort.quickSort.quickSelect

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class QuickSelect1 {
    fun findKthLargest(k: Int, nums: IntArray): Int {
        val nNums = nums.size - 1
        divide(0, nNums - 1, k, nums)
        return nums[nNums - k]
    }

    private fun divide(lo: Int, hi: Int, k: Int, nums: IntArray) {
        if (lo >= hi) return

        val nNums = nums.size
        val position = conquer(lo, hi, nums)

        when {
            position == nNums - k -> return
            position < nNums - k -> divide(position + 1, hi, k, nums)
            else -> divide(lo, nNums - 1, k, nums)
        }
    }

    private fun conquer(lo: Int, hi: Int, nums: IntArray): Int {
        val pivot = nums[hi]
        var wall = lo
        for (idx in lo until hi) {
            if (nums[idx] < pivot) {
                swap(idx, wall, nums)
                ++wall
            }
        }
        swap(wall, hi, nums)
        return wall
    }

    private fun swap(i: Int, j: Int, nums: IntArray) {
        val swap = nums[i]
        nums[i] = nums[j]
        nums[j] = swap
    }
}