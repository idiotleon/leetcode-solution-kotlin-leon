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
class Solution0SlidingWindow1 {
    fun longestOnes(nums: IntArray, k: Int): Int {
        val nNums = nums.size

        var lo = 0
        var hi = 0
        var k = k

        while (hi < nNums) {
            if (nums[hi] == 0) {
                --k
            }

            if (k < 0 && nums[lo++] == 0) {
                ++k
            }

            /*
            // equivalent
            if(k < 0){
                if(nums[lo] == 0){
                    ++k
                }
                ++lo
            }*/

            ++hi
        }

        return hi - lo
    }
}