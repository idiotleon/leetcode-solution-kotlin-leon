/**
 * https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/
 *
 * Time Complexity:     O(`totalNums`)
 * Space Complexity:    O(`totalNums`)
 *
 * also a fixed-size sliding window approach
 *
 * References:
 *  https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/discuss/238609/JavaC%2B%2BPython-One-Pass-and-O(1)-Space
 */
package com.an7one.leetcode.lvl4.lc0995

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Greedy {
    fun minKBitFlips(nums: IntArray, K: Int): Int {
        val totalNums = nums.size

        val isFlipped = IntArray(totalNums) { 0 }

        // flag
        var hasEverFlipped = 0

        // counter of the actual flips performed
        var flips = 0

        for (idx in nums.indices) {
            if (idx >= K) {
                hasEverFlipped = hasEverFlipped xor isFlipped[idx - K]
            }

            if (hasEverFlipped == nums[idx]) {
                if (idx + K > totalNums) return -1

                isFlipped[idx] = 1
                hasEverFlipped = hasEverFlipped xor 1
                ++flips
            }
        }

        return flips
    }
}