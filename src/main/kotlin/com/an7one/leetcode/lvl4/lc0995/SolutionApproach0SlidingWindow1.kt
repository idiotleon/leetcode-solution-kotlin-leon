/**
 * https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/
 *
 * Time Complexity:     O(`totalNums`)
 * Space Complexity:    O(`totalNums`)
 *
 * References:
 *  https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/discuss/238609/JavaC++Python-One-Pass-and-O(1)-Space/236804
 *  https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/discuss/238609/JavaC++Python-One-Pass-and-O(1)-Space/252674
 *  https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/discuss/238609/JavaC%2B%2BPython-One-Pass-and-O(1)-Space
 */
package com.an7one.leetcode.lvl4.lc0995

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0SlidingWindow1 {
    fun minKBitFlips(nums: IntArray, K: Int): Int {
        val totalNums = nums.size

        val isFlipped = BooleanArray(totalNums) { false }

        // the window of flipped
        // the valid flips from the past sliding window `K` till the current index
        var flippedWindow = 0

        // counter of the actual flips performed
        var flipsCount = 0

        for (idx in nums.indices) {
            if (idx >= K && isFlipped[idx - K]) {
                --flippedWindow
            }

            if (flippedWindow % 2 == nums[idx]) {
                if (idx + K > totalNums) return -1

                ++flippedWindow
                isFlipped[idx] = true
                ++flipsCount
            }
        }

        return flipsCount
    }
}