package com.an7one.leetcode.lvl3.lc0334

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/increasing-triplet-subsequence/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/increasing-triplet-subsequence/discuss/79004/Concise-Java-solution-with-comments.
 */
@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun increasingTriplet(nums: IntArray): Boolean {
        // not used
        // val nNums = nums.size

        var first = Int.MAX_VALUE
        var second = Int.MAX_VALUE

        for (num in nums) {
            when {
                num <= first -> first = num
                num <= second -> second = num
                else -> return true
            }
        }

        return false
    }
}