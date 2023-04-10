package com.idiotleon.leetcode.lvl2.lc0198

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/house-robber/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/house-robber/discuss/156523/From-good-to-great.-How-to-approach-most-of-DP-problems.
 */
@Suppress(UNUSED)
class SolutionApproach0DP0Dimen {
    fun rob(nums: IntArray): Int {
        // sanity check
        if (nums.isEmpty())
            return 0

        val nNums = nums.size
        if (nNums == 1)
            return nums[0]

        var curRobbed = 0
        var curNotRobbed = 0

        for (num in nums) {
            val prevRobbed = curRobbed
            val prevNotRobbed = curNotRobbed

            curRobbed = prevNotRobbed + num
            curNotRobbed = maxOf(prevRobbed, prevNotRobbed)
        }

        return maxOf(curRobbed, curNotRobbed)
    }
}