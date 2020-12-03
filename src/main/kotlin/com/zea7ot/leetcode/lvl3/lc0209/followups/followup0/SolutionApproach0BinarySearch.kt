/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 *
 * Time Complexity:     O(`nNums` * lg(`nNums`))
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/minimum-size-subarray-sum/discuss/59123/O(N)O(NLogN)-solutions-both-O(1)-space
 */
package com.zea7ot.leetcode.lvl3.lc0209.followups.followup0

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BinarySearch {
    fun minSubArrayLen(s: Int, nums: IntArray): Int {
        if (nums.isEmpty() || nums.sum() < s) return 0

        val nNums = nums.size

        var lo = 1
        var hi = nNums

        while (lo < hi) {
            val mid = lo + (hi - lo) / 2

            if (isValid(mid, nums, s)) {
                hi = mid
            } else {
                lo = mid + 1
            }
        }

        return lo
    }

    private fun isValid(len: Int, nums: IntArray, s: Int): Boolean {
        val nNums = nums.size

        var sum = 0

        var lo = 0
        var hi = 0

        while (hi < nNums) {
            sum += nums[hi]

            if (sum >= s) return true

            // len = hi - lo + 1
            if (hi >= len - 1) {
                sum -= nums[lo]
                ++lo
            }

            ++hi
        }

        return false
    }
}