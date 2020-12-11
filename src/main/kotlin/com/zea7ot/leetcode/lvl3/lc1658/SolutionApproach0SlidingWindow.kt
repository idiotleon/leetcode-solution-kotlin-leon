/**
 * https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/discuss/935974/C-Sliding-window-O(n)-Time-O(1)-Space
 */
package com.zea7ot.leetcode.lvl3.lc1658

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0SlidingWindow {
    fun minOperations(nums: IntArray, x: Int): Int {
        val nNums = nums.size

        var target = -x
        for (num in nums) target += num
        if (target == 0) return nNums

        var lo = 0
        var hi = 0
        var sum = 0
        var longest = -1

        while (hi < nNums) {
            sum += nums[hi]

            while (lo <= hi && sum >= target) {
                if (sum == target) {
                    longest = maxOf(longest, hi - lo + 1)
                }

                sum -= nums[lo]
                ++lo
            }

            ++hi
        }

        return if (longest == -1) -1 else nNums - longest
    }
}