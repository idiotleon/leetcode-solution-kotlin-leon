package com.idiotleon.leetcode.lvl1.lc0977

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import kotlin.math.abs

/**
 * @author: Leon
 * https://leetcode.com/problems/squares-of-a-sorted-array
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1) / O(`nNums`)
 */
@Suppress(UNUSED)
class Solution0HighLowPointer {
    fun sortedSquares(nums: IntArray): IntArray {
        val nNums = nums.size
        val ans = IntArray(nNums)

        var lo = 0
        var hi = nNums - 1

        var idx = nNums - 1

        while (lo <= hi) {
            val numLo = abs(nums[lo])
            val numHi = abs(nums[hi])

            ans[idx] = if (numLo < numHi) {
                --hi
                numHi * numHi
            } else {
                ++lo
                numLo * numLo
            }

            --idx
        }

        return ans
    }
}