/**
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://algs4.cs.princeton.edu/23quicksort/Quick.java.html
 */
package com.zea7ot.summary.byAlgorithm.sort.quickSort.oneWay

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class QuickSort1Way {
    fun quickSort(nums: IntArray) = quickSort(0, nums.size - 1, nums)

    fun quickSort(lo: Int, hi: Int, nums: IntArray) {
        if (lo >= hi) return

        val pivot = partition(lo, hi, nums)
        quickSort(lo, pivot - 1, nums)
        quickSort(pivot + 1, hi, nums)
    }

    private fun partition(low: Int, high: Int, nums: IntArray): Int {
        var lo = low
        var hi = high + 1

        val pivot = nums[lo]

        while (true) {
            // to find the item on `lo` for swapping
            while (nums[++lo] < pivot) {
                if (lo == high) break
            }

            // to find the item on `hi` for swapping
            while (pivot < nums[--hi]) {
                if (hi == low) break // this is redundant since `nums[lo]` acts as a sentinel
            }

            // to check if two pointers cross
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