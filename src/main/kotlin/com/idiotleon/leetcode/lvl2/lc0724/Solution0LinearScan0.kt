package com.idiotleon.leetcode.lvl2.lc0724

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/find-pivot-index/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/find-pivot-index/editorial/
 */
@Suppress(UNUSED)
class Solution0LinearScan0 {
    fun pivotIndex(nums: IntArray): Int {
        val nNums = nums.size
        val totalSum = nums.sum()

        var loSum = 0

        for ((idx, num) in nums.withIndex()) {
            val hiSum = totalSum - num - loSum
            if (loSum == hiSum) {
                return idx
            }

            // the key is to judge *before* addition
            loSum += num
        }

        return -1
    }
}