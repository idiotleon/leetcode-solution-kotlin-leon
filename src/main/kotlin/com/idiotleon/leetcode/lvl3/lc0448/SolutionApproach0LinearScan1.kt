package com.idiotleon.leetcode.lvl3.lc0448

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/discuss/93007/Simple-Java-In-place-sort-solution
 */
@Suppress(UNUSED)
class SolutionApproach0LinearScan1 {
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        // not used
        // val nNums = nums.size

        for (idx in nums.indices) {
            while (nums[idx] != idx + 1 && nums[idx] != nums[nums[idx] - 1]) {
                val temp = nums[idx]
                nums[idx] = nums[temp - 1]
                nums[temp - 1] = temp
            }
        }


        val ans = mutableListOf<Int>()
        for (idx in nums.indices) {
            if (nums[idx] != idx + 1) {
                ans.add(idx + 1)
            }
        }

        return ans
    }
}