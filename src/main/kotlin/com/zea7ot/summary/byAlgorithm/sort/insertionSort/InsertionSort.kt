/**
 * References:
 *  https://algs4.cs.princeton.edu/21elementary/Insertion.java.html
 */
package com.zea7ot.summary.byAlgorithm.sort.insertionSort

class InsertionSort {
    /**
     * to sort the array in the ascending order, using the natural order
     * @param nums the array to be sorted
     */
    fun sort(nums: IntArray) {
        val nNums = nums.size

        for (hi in 1 until nNums) {
            for (lo in hi downTo 1) {
                if (nums[lo - 1] < nums[lo]) break
                swap(lo - 1, lo, nums)
            }
        }
    }

    /**
     * to sort the array in the ascending order, using the natural order
     * @param low the left endpoint (inclusive)
     * @param high the right endpoint (exclusive)
     * @param nums the array to be sorted
     */
    fun sort(low: Int, high: Int, nums: IntArray) {
        for (hi in low + 1 until high) {
            for (lo in hi downTo low + 1) {
                if (nums[lo - 1] < nums[lo]) break
                swap(lo - 1, lo, nums)
            }
        }
    }

    private fun swap(lo: Int, hi: Int, nums: IntArray) {
        val temp = nums[lo]
        nums[lo] = nums[hi]
        nums[hi] = temp
    }
}