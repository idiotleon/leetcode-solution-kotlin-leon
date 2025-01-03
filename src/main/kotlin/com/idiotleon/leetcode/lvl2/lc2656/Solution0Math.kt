package com.idiotleon.leetcode.lvl2.lc2656

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/maximum-sum-with-exactly-k-elements/
 *
 * Time Complexity:     O(1)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution0Math {
    fun maximizeSum(nums: IntArray, k: Int): Int {
        val nNums = nums.size
        val max = nums.max()

        return k * (max + max + k - 1) / 2
    }
}