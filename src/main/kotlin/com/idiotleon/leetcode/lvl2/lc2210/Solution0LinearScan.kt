package com.idiotleon.leetcode.lvl2.lc2210

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/count-hills-and-valleys-in-an-array/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/count-hills-and-valleys-in-an-array/solutions/1879182/two-pointers/comments/1501271
 * https://leetcode.com/problems/count-hills-and-valleys-in-an-array/solutions/1879182/two-pointers/?envType=company&envId=facebook&favoriteSlug=facebook-six-months
 */
@Suppress(UNUSED)
class Solution0LinearScan {
    fun countHillValley(nums: IntArray): Int {
        val nNums = nums.size
        var prev = nums[0]
        var countHills = 0
        var countValleys = 0

        for (idx in 1 until nNums - 1) {
            if (nums[idx] == prev) {
                continue
            }

            if (nums[idx] > prev && nums[idx] > nums[idx + 1]) {
                ++countHills
                prev = nums[idx]
            } else if (nums[idx] < prev && nums[idx] < nums[idx + 1]) {
                ++countValleys
                prev = nums[idx]
            }
        }

        return countHills + countValleys
    }
}