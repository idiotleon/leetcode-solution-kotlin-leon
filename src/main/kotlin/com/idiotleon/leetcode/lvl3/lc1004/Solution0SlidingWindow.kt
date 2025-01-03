package com.idiotleon.leetcode.lvl3.lc1004

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/max-consecutive-ones-iii/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/max-consecutive-ones-iii/discuss/247564/JavaC%2B%2BPython-Sliding-Window
 */
@Suppress(UNUSED)
class Solution0SlidingWindow {
    fun longestOnes(nums: IntArray, k: Int): Int {
        val nNums = nums.size
        var longest = 0
        var countZero = 0

        var lo = 0
        var hi = 0

        while (hi < nNums) {
            if (nums[hi] == 0) {
                ++countZero
            }

            while (countZero > k) {
                if (nums[lo] == 0) {
                    --countZero
                }
                ++lo
            }

            val len = hi - lo + 1
            longest = maxOf(longest, len)

            ++hi
        }

        return longest
    }
}