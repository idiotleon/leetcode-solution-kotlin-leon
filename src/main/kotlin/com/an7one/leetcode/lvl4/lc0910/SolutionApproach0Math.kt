/**
 * https://leetcode.com/problems/smallest-range-ii/
 *
 * Time Complexity:     O(`nNums` * lg(`nNums`))
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/smallest-range-ii/discuss/173377/C%2B%2BJavaPython-Add-0-or-2-*-K
 */
package com.an7one.leetcode.lvl4.lc0910

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Math {
    fun smallestRangeII(nums: IntArray, k: Int): Int {
        val nNums = nums.size

        nums.sort()

        var max = nums.last()
        var min = nums.first()
        var ans = max - min

        for (idx in 0 until nNums - 1) {
            max = maxOf(max, nums[idx] + 2 * k)
            min = minOf(nums[idx + 1], nums[0] + 2 * k)
            ans = minOf(ans, max - min)
        }

        return ans
    }
}