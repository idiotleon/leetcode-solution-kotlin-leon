package com.idiotleon.leetcode.lvl2.lc0215

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 *
 * Time Complexity:     O(`nNums`), O(`nNums` ^ 2) in the worst case
 * Space Complexity:    O(1)
 *
 * References:
 *  https://algs4.cs.princeton.edu/23quicksort/Quick.java.html
 *  https://mp.weixin.qq.com/s/TRO3FOKT90Mpvn3hQWVBAQ
 */
@Suppress(UNUSED)
class SolutionApproach0QuickSelect {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val nNums = nums.size

        val kLargest = nNums - k
        var lo = 0
        var hi = nNums - 1

        while (lo <= hi) {
            val pivot = partition(lo, hi, nums)

            when {
                pivot < kLargest -> lo = pivot + 1
                pivot > kLargest -> hi = pivot - 1
                else -> return nums[pivot]
            }
        }

        return -1
    }

    private fun partition(low: Int, high: Int, nums: IntArray): Int {
        if (low == high)
            return low

        var lo = low
        var hi = high + 1

        val pivot = nums[low]

        while (true) {
            while (nums[++lo] < pivot) {
                if (lo == high)
                    break
            }

            while (pivot < nums[--hi]) {
                if (hi == low)
                    break
            }

            if (lo >= hi) break


            swap(lo, hi, nums)
        }

        swap(low, hi, nums)

        return hi
    }

    private fun swap(lo: Int, hi: Int, nums: IntArray) {
        val temp = nums[lo]
        nums[lo] = nums[hi]
        nums[hi] = temp
    }
}