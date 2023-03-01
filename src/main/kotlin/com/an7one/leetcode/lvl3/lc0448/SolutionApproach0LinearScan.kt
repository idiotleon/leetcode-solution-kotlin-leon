package com.an7one.leetcode.lvl3.lc0448

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 *
 * Time Complexity:     O(`nNUms`)
 * Space Complexity:    O(`nNums`)
 *
 * Reference:
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/discuss/92980/5-line-Java-Easy-understanding
 */
@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        val nNums = nums.size
        val ans = mutableListOf<Int>()

        for (num in nums) {
            nums[(num - 1) % nNums] += nNums
        }

        for (idx in nums.indices) {
            if (nums[idx] <= nNums) ans.add(idx + 1)
        }

        return ans
    }
}