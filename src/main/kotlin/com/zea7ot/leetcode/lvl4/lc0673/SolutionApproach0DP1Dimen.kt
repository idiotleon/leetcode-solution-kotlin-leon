/**
 * https://leetcode.com/problems/number-of-longest-increasing-subsequence/
 *
 * Time Complexity:     O(`totalNums` ^ 2)
 * Space Complexity:    O(`totalNums`)
 *
 * References:
 *  https://leetcode.com/problems/number-of-longest-increasing-subsequence/discuss/107318/C%2B%2B-DP-with-explanation-O(n2)
 */
package com.zea7ot.leetcode.lvl4.lc0673

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun findNumberOfLIS(nums: IntArray): Int {
        // sanity check, not required
        // if (nums.isEmpty()) return 0

        val nNums = nums.size
        val lens = IntArray(nNums) { 1 }
        val counts = IntArray(nNums) { 1 }

        var longest = 0

        for (hi in nums.indices) {
            for (lo in 0 until hi) {
                if (nums[lo] < nums[hi]) {
                    if (lens[hi] == lens[lo] + 1) {
                        counts[hi] += counts[lo]
                    } else if (lens[hi] < lens[lo] + 1) {
                        lens[hi] = lens[lo] + 1
                        counts[hi] = counts[lo]
                    }
                }
            }

            longest = maxOf(longest, lens[hi])
        }

        var count = 0
        for (idx in lens.indices) {
            if (lens[idx] == longest) {
                count += counts[idx]
            }
        }

        return count
    }
}