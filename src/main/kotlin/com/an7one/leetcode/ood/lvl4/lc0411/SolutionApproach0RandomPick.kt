/**
 * https://leetcode.com/problems/online-majority-element-in-subarray/
 *
 * Time Complexities:
 *  initialization:     O()
 *  `query`:            O()
 *
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/online-majority-element-in-subarray/discuss/356227/C++-Codes-of-different-approaches-(Random-Pick-Trade-off-Segment-Tree-Bucket)/336843
 *  https://leetcode.com/problems/online-majority-element-in-subarray/discuss/356227/C%2B%2B-Codes-of-different-approaches-(Random-Pick-Trade-off-Segment-Tree-Bucket)
 */
package com.an7one.leetcode.ood.lvl4.lc0411

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import kotlin.random.Random

@Suppress(UNUSED)
class SolutionApproach0RandomPick(private val nums: IntArray) {
    private val numToIndices = HashMap<Int, MutableList<Int>>()

    init {
        for (idx in nums.indices) {
            numToIndices.getOrPut(nums[idx]) { mutableListOf() }.add(idx)
        }
    }

    fun query(left: Int, right: Int, threshold: Int): Int {
        for (idx in 0 until 10) {
            val num = nums[getRandomNum(left, right)]
            if (getOccurrences(left, right, num) >= threshold) {
                return num
            }
        }

        return -1
    }

    private fun getOccurrences(left: Int, right: Int, num: Int): Int {
        val indices = numToIndices[num]!!
        var lo = indices.binarySearch(left)
        if (lo < 0) lo = lo.inv()
        if (lo == indices.size) return 0

        var hi = indices.binarySearch(right)
        if (hi < 0) hi = hi.inv() - 1
        return hi - lo + 1
    }

    private fun getRandomNum(lo: Int, hi: Int) = Random.nextInt(hi - lo + 1) + lo
}