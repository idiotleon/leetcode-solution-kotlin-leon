/**
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/shortest-unsorted-continuous-subarray/discuss/103057/Java-O(n)-Time-O(1)-Space
 */
package com.zea7ot.leetcode.lvl2.lc0581

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Greedy {
    fun findUnsortedSubarray(nums: IntArray): Int {
        val nNums = nums.size

        var start = -1
        var end = -2
        var min = nums.last()
        var max = nums.first()

        for (idx in 1 until nNums) {
            max = maxOf(max, nums[idx])
            min = minOf(min, nums[nNums - 1 - idx])

            if (nums[idx] < max) end = idx
            if (nums[nNums - 1 - idx] > min) start = nNums - 1 - idx
        }

        return end - start + 1
    }
}