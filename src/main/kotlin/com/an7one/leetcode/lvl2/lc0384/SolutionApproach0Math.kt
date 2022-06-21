package com.an7one.leetcode.lvl2.lc0384

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import kotlin.random.Random

/**
 * @author: Leon
 * https://leetcode.com/problems/shuffle-an-array/
 *
 * Time Complexities:
 *  `shuffle`:  O(`nNums`)
 *  `reset`:    O(1)
 *
 * Space Complexity:    O(`nNums`)
 *
 * Reference:
 *  https://leetcode.com/problems/shuffle-an-array/discuss/85958/First-Accepted-Solution-Java
 */
@Suppress(UNUSED)
class SolutionApproach0Math(private val nums: IntArray) {
    private val nNums = nums.size

    /** Resets the array to its original configuration and return it. */
    fun reset(): IntArray {
        return nums
    }

    /** Returns a random shuffling of the array. */
    fun shuffle(): IntArray {
        val cloned = nums.copyOf()
        for (hi in 1 until nNums) {
            val lo = Random.nextInt(hi + 1)
            swap(lo, hi, cloned)
        }
        return cloned
    }

    private fun swap(i: Int, j: Int, nums: IntArray) {
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }
}