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
package com.an7one.leetcode.lvl2.lc0001

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0HashMap {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        // not used
        // val nNums = nums.size

        val sumToIdx = HashMap<Int, Int>()

        for ((idx, num) in nums.withIndex()) {
            val expectedSum = target - num

            sumToIdx[expectedSum]?.let {
                if (it != idx)
                    return intArrayOf(it, idx)
            }

            sumToIdx[num] = idx
        }

        return intArrayOf()
    }
}