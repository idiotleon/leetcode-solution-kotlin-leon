/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/minimum-window-substring/discuss/26808/Here-is-a-10-line-template-that-can-solve-most-'substring'-problems
 */
package com.zea7ot.leetcode.lvl2.lc0209

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0SlidingWindow {
    fun minSubArrayLen(s: Int, nums: IntArray): Int {
        val nNums = nums.size

        var lo = 0
        var hi = 0
        var sum = 0
        var shortest = nNums + 1

        while (hi < nNums) {
            sum += nums[hi]

            while (sum >= s) {
                shortest = minOf(shortest, hi - lo + 1)
                sum -= nums[lo]
                ++lo
            }

            ++hi
        }

        return shortest % (nNums + 1)
    }
}