package com.idiotleon.leetcode.lvl2.lc0268.followups.followup0

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/missing-number/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/missing-number/discuss/69786/3-different-ideas:-XOR-SUM-Binary-Search.-Java-code/71844
 */
@Suppress(UNUSED)
class SolutionApproach0Math {
    fun missingNumber(nums: IntArray): Int {
        val nNums = nums.size

        var sum = 0
        // this helps prevent integer overflow
        for (idx in nums.indices) {
            sum += idx
            sum -= nums[idx]
        }

        sum += nNums
        return sum
    }
}