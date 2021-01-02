/**
 * @author: Leon
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(`DATA_RANGE`)
 *
 * stable
 *
 * References:
 *  1min ~ 14:40min: https://www.bilibili.com/video/BV1QE411X7mA
 */
package com.zea7ot.summary.byAlgorithm.sort.countingSort

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class CountingSort {
    private companion object {
        private const val DATA_RANGE = 1e6.toInt() + 7
    }

    fun countingSort(nums: IntArray) {
        val nNums = nums.size
        val auxiliary = IntArray(nNums) { 0 }

        val counts = IntArray(DATA_RANGE) { 0 }
        for (num in nums) {
            ++counts[num]
        }

        for (idx in 1 until DATA_RANGE - 1) {
            counts[idx] += counts[idx - 1]
        }

        for (idx in auxiliary.indices.reversed()) {
            val num = nums[idx]
            auxiliary[counts[num - 1]] = num
            --counts[num]
        }

        for (idx in auxiliary.indices) {
            nums[idx] = auxiliary[idx]
        }
    }
}