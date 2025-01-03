package com.idiotleon.leetcode.lvl2.lc1863

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/sum-of-all-subset-xor-totals/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/sum-of-all-subset-xor-totals/editorial/
 */
@Suppress(UNUSED)
class Solution0BitManipulation {
    fun subsetXORSum(nums: IntArray): Int {
        val nNums = nums.size

        var ans = 0
        for (num in nums) {
            ans = ans or num
        }

        return ans shl (nNums - 1)
    }
}