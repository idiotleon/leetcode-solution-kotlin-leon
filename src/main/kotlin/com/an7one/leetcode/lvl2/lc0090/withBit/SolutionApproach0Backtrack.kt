package com.an7one.leetcode.lvl2.lc0090.withBit

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/subsets-ii/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.wang/leetCode-90-SubsetsII.html
 */
@Suppress(UNUSED)
class SolutionApproach0Backtrack {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        val nNums = nums.size
        nums.sort()

        val paths = mutableListOf<List<Int>>()

        val range = 1 shl nNums

        for (bitMask in 0 until range) {
            val path = mutableListOf<Int>()
            var isLegal = true
            for (idx in nums.indices) {
                if ((bitMask and (1 shl idx)) != 0) {
                    if (idx > 0 && nums[idx - 1] == nums[idx] && (bitMask and (1 shl (idx - 1))) == 0) {
                        isLegal = false
                        break
                    } else {
                        path.add(nums[idx])
                    }
                }
            }

            if (isLegal) {
                paths.add(path)
            }
        }

        return paths
    }
}