package com.idiotleon.summary.byAlgorithm.sort.quickSort

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 *
 * Time Complexity:
 *  O(`nNums` * lg(`nNums`)) on average
 *  O(`nNums` ^ 2) in the worst case
 *
 * Space Complexity:        O(1)
 *
 * Reference:
 * https://www.baeldung.com/java-quicksort
 */
@Suppress(UNUSED)
class QuickSortPartitionWithEnd {
    fun quickSort(lo: Int, hi: Int, nums: IntArray) {
        if (lo >= hi) {
            return
        }

        val pivot = partition(lo, hi, nums)
        quickSort(lo, pivot - 1, nums)
        quickSort(pivot + 1, hi, nums)
    }

    private fun partition(low: Int, high: Int, nums: IntArray): Int {
        val pivot = nums[high]
        var lo = low - 1

        for (hi in low until high) {
            if (nums[hi] > pivot) {
                continue
            }
            ++lo
            swap(lo, hi, nums)
        }

        swap(lo + 1, high, nums)
        return 1 + lo
    }

    private fun swap(i: Int, j: Int, nums: IntArray) {
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }
}