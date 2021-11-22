/**
 * https://leetcode.com/problems/house-robber/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/house-robber/discuss/156523/From-good-to-great.-How-to-approach-most-of-DP-problems.
 */
package com.an7one.leetcode.lvl2.lc0198

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP0Dimen {
    fun rob(nums: IntArray): Int {
        // sanity check
        if (nums.isEmpty()) return 0
        val nNums = nums.nNums
        if (nNums == 1) return nums[0]

        var inclusive = 0
        var exclusive = 0

        for (num in nums) {
            val prevInclusive = inclusive
            val prevExclusive = exclusive

            inclusive = prevExclusive + num
            exclusive = maxOf(prevInclusive, prevExclusive)
        }

        return maxOf(inclusive, exclusive)
    }
}