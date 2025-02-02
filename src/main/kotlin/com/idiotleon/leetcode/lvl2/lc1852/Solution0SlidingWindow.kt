package com.idiotleon.leetcode.lvl2.lc1852

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/distinct-numbers-in-each-subarray/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(0) / O(`k`)
 */
@Suppress(UNUSED)
private class Solution0SlidingWindow {
    fun distinctNumbers(nums: IntArray, k: Int): IntArray {
        val nNums = nums.size
        val max = nums.max()

        var count = 0
        val freqs = IntArray(1 + max) { 0 }

        val ans = IntArray(nNums - k + 1) { 0 }
        var idx = 0
        for (hi in 0 until nNums) {
            if (freqs[nums[hi]]++ == 0) {
                ++count
            }
            if (hi >= k - 1) {
                ans[idx++] = count
                val lo = hi - k + 1
                if (--freqs[nums[lo]] == 0) {
                    --count
                }
            }
        }

        return ans
    }
}