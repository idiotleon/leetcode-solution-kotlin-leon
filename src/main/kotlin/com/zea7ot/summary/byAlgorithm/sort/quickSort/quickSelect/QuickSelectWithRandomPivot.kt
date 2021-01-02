/**
 * @author: Leon
 *
 * Time Complexity:
 *  Best:       O(`nNums`)
 *  Average:    O(`nNums`)
 *  Worst:      O(`nNums` ^ 2)
 *
 * `k` is 0-indexed
 */
package com.zea7ot.summary.byAlgorithm.sort.quickSort.quickSelect

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import kotlin.random.Random

@Suppress(UNUSED)
class QuickSelectWithRandomPivot {
    fun quickSelect(lo: Int, hi: Int, k: Int, nums: IntArray): Int {
        if (lo <= hi) {
            val pivot = partition(lo, hi, nums)
            return when {
                pivot > k -> quickSelect(lo, pivot - 1, k, nums)
                pivot < k -> quickSelect(pivot + 1, hi, k, nums)
                else -> nums[k]
            }
        }

        return Int.MIN_VALUE
    }

    private fun partition(lo: Int, hi: Int, nums: IntArray): Int {
        val pivot = lo + Random.nextInt(hi - lo + 1)
        swap(pivot, hi, nums)

        var lo = lo
        for (idx in lo until hi) {
            if (nums[idx] > nums[hi]) {
                swap(lo, idx, nums)
                ++lo
            }
        }

        swap(lo, hi, nums)
        return lo
    }

    private fun swap(i: Int, j: Int, nums: IntArray) {
        val swap = nums[i]
        nums[i] = nums[j]
        nums[j] = swap
    }
}