package com.idiotleon.leetcode.lvl3.lc0169

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/majority-element/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 *
 * the description of the problem guarantees that there always will be a majority element
 *
 * Reference:
 * https://youtu.be/SWr4cSY2fCk?t=501
 */
@Suppress(UNUSED)
class SolutionApproach0MooreVotingAlgorithm {
    fun majorityElement(nums: IntArray): Int {
        var count = 0
        var candidate = 0

        for (num in nums) {
            if (count == 0) candidate = num

            count += if (num == candidate) 1 else -1
        }

        return candidate
    }
}