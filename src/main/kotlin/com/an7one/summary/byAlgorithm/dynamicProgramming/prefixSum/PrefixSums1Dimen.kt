package com.an7one.summary.byAlgorithm.dynamicProgramming.prefixSum

import com.an7one.leetcode.util.Constant

@Suppress(Constant.Annotation.UNUSED)
class PrefixSums1Dimen {
    fun getPrefixSums(nums: IntArray): IntArray {
        val nNums = nums.size

        val prefixSums = IntArray(1 + nNums) { 0 }
        for (idx in nums.indices) {
            prefixSums[idx + 1] = prefixSums[idx] + nums[idx]
        }

        return prefixSums
    }

    fun getPrefixSums1(nums: IntArray): IntArray {
        val nNums = nums.size

        val prefixSums = IntArray(1 + nNums) { 0 }
        for (idx in 1..nNums) {
            prefixSums[idx] = prefixSums[idx - 1] + nums[idx]
        }

        return prefixSums
    }

    /**
     * to get the sum of the subarray [lo, hi]
     *
     * @param lo
     * @param hi
     * @return the sum of the subarray
     */
    fun getSubarraySum(lo: Int, hi: Int, prefixSums: IntArray): Int {
        // prefixSums[hi]:      nums[0] + nums[1] + ... + nums[lo - 1] + nums[lo] + ... + nums[hi]
        // prefixSums[lo - 1]:  nums[0] + nums[1] + ... + nums[lo - 1]
        return prefixSums[hi] - prefixSums[lo - 1]
    }
}