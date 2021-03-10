/**
 * @author: Leon
 *
 * References:
 *  Paid Membership Required: https://www.acwing.com/video/11/
 */
package com.an7one.summary.byAlgorithm.dynamicProgramming.differenceArray

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class DiffArray1Dimen {
    fun createDiffArray(nums: IntArray): IntArray {
        val nNums = nums.size

        val diffArr = IntArray(nNums) { 0 }
        for (idx in 1..nNums) {
            insert(idx, idx, nums[idx], diffArr)
        }

        return diffArr
    }

    private fun insert(lo: Int, hi: Int, diff: Int, diffArr: IntArray) {
        diffArr[lo] += diff
        diffArr[hi + 1] -= diff
    }
}