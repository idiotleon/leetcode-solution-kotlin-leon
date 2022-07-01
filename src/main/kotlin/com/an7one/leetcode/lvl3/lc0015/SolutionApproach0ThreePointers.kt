package com.an7one.leetcode.lvl3.lc0015

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/3sum/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class SolutionApproach0ThreePointers {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val nNums = nums.size
        nums.sort()

        val ans = mutableListOf<List<Int>>()

        for (idx in 0 until nNums - 2) {
            if (idx > 0 && nums[idx - 1] == nums[idx]) continue

            var lo = idx + 1
            var hi = nNums - 1

            val target = -nums[idx]

            while (lo < hi) {
                val sum = nums[lo] + nums[hi]

                when {
                    sum == target -> {
                        ans.add(listOf(nums[idx], nums[lo], nums[hi]))

                        ++lo
                        --hi

                        while (lo < hi && nums[lo - 1] == nums[lo]) ++lo
                        while (lo < hi && nums[hi] == nums[hi + 1]) --hi
                    }
                    sum > target -> --hi
                    else -> ++lo
                }
            }
        }

        return ans
    }
}