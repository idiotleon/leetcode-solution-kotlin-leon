/**
 * https://leetcode.com/problems/divide-array-into-increasing-sequences/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/divide-array-into-increasing-sequences/discuss/334115/Java-6-liner-and-7-liner-w-explanation-and-complexity-analysis.
 */
package com.idiotleon.leetcode.lvl4.lc1121

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Greedy {
    fun canDivideIntoSubsequences(nums: IntArray, K: Int): Boolean {
        val nNums = nums.size

        var mostFreq = 1
        var prev = -1
        var count = 1

        for (cur in nums) {
            count = if (prev == cur) ++count else 1
            prev = cur
            mostFreq = maxOf(mostFreq, count)
        }

        return nNums / mostFreq >= K
    }
}