/**
 * https://leetcode.com/problems/missing-ranges/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 */
package com.zea7ot.leetcode.lvl3.lc0163

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun findMissingRanges(nums: IntArray, lower: Int, upper: Int): List<String> {
        val ans = arrayListOf<String>()
        if (nums.isEmpty()) {
            ans.add(getRange(lower, upper))
            return ans
        }

        val size = nums.size

        if (nums[0] > lower)
            ans.add(getRange(lower, nums[0] - 1))

        for (i in 0 until size - 1)
            if (nums[i + 1] != nums[i] && nums[i + 1] > nums[i] + 1)
                ans.add(getRange(nums[i] + 1, nums[i + 1] - 1))

        if (nums[size - 1] < upper)
            ans.add(getRange(nums[size - 1] + 1, upper))

        return ans
    }

    private fun getRange(lo: Int, hi: Int): String {
        return if (lo == hi) lo.toString() else String.format("%d->%d", lo, hi)
    }
}