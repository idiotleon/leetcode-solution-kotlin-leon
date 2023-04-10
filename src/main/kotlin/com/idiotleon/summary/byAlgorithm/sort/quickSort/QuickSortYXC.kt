/**
 * YXC: 大雪菜闫学灿
 *
 * References:
 *  Paid Membership Required: https://www.acwing.com/video/10/
 *  Paid Membership Required: https://www.acwing.com/video/11/
 */
package com.idiotleon.summary.byAlgorithm.sort.quickSort

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class QuickSortYXC {
    fun quickSort(low: Int, high: Int, nums: IntArray) {
        if (low >= high) return

        // version 1
        val pivot = nums[low]
        // version 2
        // val pivot = nums[(low + high) / 2)]

        // version 3
        // val pivot = nums[high]
        // version 4
        // val pivot = nums[(low + high + 1) / 2]

        var lo = low - 1
        var hi = high + 1

        while (lo < hi) {
            do lo++ while (nums[lo] < pivot)
            do hi-- while (nums[hi] > pivot)
            if (lo < hi) swap(lo, hi, nums)
        }

        // version 1 & 2
        quickSort(low, hi, nums)

        // version 3 & 4
        // quickSort(low, lo - 1, nums)

        // version 1 & 2
        quickSort(hi + 1, high, nums)

        // version 3 & 4
        // quickSort(lo + 1, high, nums)
    }

    private fun swap(lo: Int, hi: Int, nums: IntArray) {
        val temp = nums[lo]
        nums[lo] = nums[hi]
        nums[hi] = temp
    }
}