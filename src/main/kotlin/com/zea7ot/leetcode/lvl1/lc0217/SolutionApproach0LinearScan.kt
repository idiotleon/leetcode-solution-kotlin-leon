/**
 * https://leetcode.com/problems/contains-duplicate/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(`nNums`)
 */
package com.zea7ot.leetcode.lvl1.lc0217

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun containsDuplicate(nums: IntArray): Boolean {
        val seen = HashSet<Int>()

        for (num in nums) {
            if (!seen.add(num)) {
                return true
            }
        }

        return false
    }
}