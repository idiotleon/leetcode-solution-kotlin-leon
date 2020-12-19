/**
 * https://leetcode.com/problems/increasing-triplet-subsequence/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/increasing-triplet-subsequence/discuss/79004/Concise-Java-solution-with-comments.
 */
package com.zea7ot.leetcode.lvl3.lc0334

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

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