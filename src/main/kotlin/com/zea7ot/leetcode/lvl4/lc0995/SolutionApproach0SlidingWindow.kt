/**
 * https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/
 *
 * Time Complexity:     O(`totalNums`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/discuss/238609/JavaC%2B%2BPython-One-Pass-and-O(1)-Space
 */
package com.zea7ot.leetcode.lvl4.lc0995

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0SlidingWindow {
    private companion object {
        private const val MARK_FLIPPED = 2
    }

    fun minKBitFlips(nums: IntArray, K: Int): Int {
        val totalNums = nums.size

        var flippedWindow = 0

        var flipsCounter = 0

        for (idx in nums.indices) {
            if (idx >= K && nums[idx - K] > 1) {
                --flippedWindow
                nums[idx - K] -= MARK_FLIPPED
            }

            if (flippedWindow % 2 == nums[idx]) {
                if (idx + K > totalNums) return -1
                nums[idx] += MARK_FLIPPED
                ++flippedWindow

                ++flipsCounter
            }
        }

        return flipsCounter
    }
}