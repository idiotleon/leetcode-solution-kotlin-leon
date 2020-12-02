/**
 * https://leetcode.com/problems/divide-array-into-increasing-sequences/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(`RANGE`)
 *
 * References:
 *  https://leetcode.com/problems/divide-array-into-increasing-sequences/discuss/334115/Java-6-liner-and-7-liner-w-explanation-and-complexity-analysis.
 */
package com.zea7ot.leetcode.lvl4.lc1121

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0CountingSort {
    private companion object {
        private const val RANGE = 1e5.toInt() + 1
    }

    fun canDivideIntoSubsequences(nums: IntArray, K: Int): Boolean {
        val nNums = nums.size

        var mostFreq = 0
        val counts = IntArray(RANGE) { 0 }

        for (num in nums) {
            if (++counts[num] > mostFreq) {
                mostFreq = counts[num]
            }
        }

        return nNums / mostFreq >= K
    }
}