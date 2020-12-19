/**
 * YXC: 大雪菜闫学灿
 *
 * References:
 *  Paid Membership Required: https://www.acwing.com/video/10/
 */
package com.zea7ot.summary.byAlgorithm.sort.mergeSort

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class MergeSortYXC {
    fun mergeSort(low: Int, high: Int, nums: IntArray, temp: IntArray) {
        if (low >= high) return

        val mid = low + (high - low) / 2

        mergeSort(low, mid, nums, temp)
        mergeSort(mid + 1, high, nums, temp)

        var idx = 0
        var lo = low
        var hi = mid + 1
        while (lo <= mid && hi <= high) {
            if (nums[lo] <= nums[hi]) temp[idx++] = nums[lo++]
            else temp[idx++] = nums[hi++]
        }

        while (lo <= mid) temp[idx++] = nums[lo++]
        while (hi <= high) temp[idx++] = nums[hi++]

        var idxNum = 1
        var idxTemp = 0

        while (idxNum <= high) {
            nums[idxNum] = temp[idxTemp]
            ++idxNum
            ++idxTemp
        }
    }
}