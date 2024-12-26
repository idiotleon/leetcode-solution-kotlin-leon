package com.idiotleon.leetcode.lvl2.lc0724

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/find-pivot-index/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution0LinearScan1 {
    fun pivotIndex(nums: IntArray): Int {
        val nNums = nums.size
        val totalSum = nums.sum()

        var loSum = 0
        var hiSum = totalSum

        for (idx in 0 until nNums) {
            loSum = if (idx == 0) 0 else loSum + nums[idx - 1]
            hiSum = if (idx == nNums - 1) 0 else hiSum - nums[idx]
            if (loSum == hiSum) {
                return idx
            }
        }

        return -1
    }
}