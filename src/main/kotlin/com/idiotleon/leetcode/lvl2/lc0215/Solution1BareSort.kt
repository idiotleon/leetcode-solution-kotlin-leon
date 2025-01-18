package com.idiotleon.leetcode.lvl2.lc0215

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 *
 * Time Complexity:     O(`nNums` * lg(`nNums`))
 * Space Complexity:    O(lg(`nNums`))
 */
@Suppress(UNUSED)
class Solution1BareSort {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val nNums = nums.size

        nums.sortDescending()

        return nums[k - 1]
    }
}