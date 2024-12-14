package com.idiotleon.leetcode.lvl2.lc0001

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/two-sum/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(`nNums`)
 *
 * Reference:
 *  https://leetcode.com/problems/two-sum/discuss/715951/Rust%3A-HashMap-solution
 */
@Suppress(UNUSED)
class SolutionApproach0HashMap {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val nNums = nums.size

        val sumToIdx = HashMap<Int, Int>(nNums)

        for ((idx, num) in nums.withIndex()) {
            val expectedSum = target - num

            sumToIdx[expectedSum]?.let {
                if (it != idx) {
                    return intArrayOf(it, idx)
                }
            }

            sumToIdx[num] = idx
        }

        return intArrayOf()
    }
}