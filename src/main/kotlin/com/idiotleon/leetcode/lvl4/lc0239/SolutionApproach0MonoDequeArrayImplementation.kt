package com.idiotleon.leetcode.lvl4.lc0239

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/sliding-window-maximum/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(`nNums`) / O(1)
 *
 * Reference:
 * Paid Course, 110min: https://www.acwing.com/video/15/
 */
@Suppress(UNUSED)
class SolutionApproach0MonoDequeArrayImplementation {
    private companion object {
        private const val VALUE_RANGE = 1e4.toInt() + 7
    }

    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val nNums = nums.size
        val lenSlidingWindow = nNums - k + 1
        val ans = IntArray(lenSlidingWindow) { 0 }

        val deque = IntArray(lenSlidingWindow + 1) { -VALUE_RANGE }
        var idxHead = 0
        var idxTail = -1

        for (idx in nums.indices) {
            if (idxHead <= idxTail && idx - k + 1 > deque[idxHead]) ++idxHead

            while (idxHead <= idxTail && nums[deque[idxTail]] <= nums[idx]) --idxTail

            deque[++idxTail] = idx

            if (idx >= k - 1) {
                ans[idx - k + 1] = nums[deque[idxHead]]
            }
        }

        return ans
    }
}