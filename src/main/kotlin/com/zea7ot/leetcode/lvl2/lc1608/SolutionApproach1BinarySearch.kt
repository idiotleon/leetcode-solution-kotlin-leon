/**
 * https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/
 *
 * Time Complexity:     O(`nNums` * lg(`nNums`))
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/discuss/882910/Java-Beats-100-Two-Binary-Search-methods-and-detailed-explanation/748534
 *  https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/discuss/882910/Java-Beats-100-Two-Binary-Search-methods-and-detailed-explanation
 */
package com.zea7ot.leetcode.lvl2.lc1608

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach1BinarySearch {
    fun specialArray(nums: IntArray): Int {
        val nNums = nums.size

        nums.sort()
        for (idx in 0..nNums) {
            var lo = 0
            var hi = nNums

            while (lo < hi) {
                val mid = lo + (hi - lo) / 2
                if (nums[mid] >= idx) hi = mid
                else lo = mid + 1
            }

            if (nNums - lo == idx) return idx
        }

        return -1
    }
}