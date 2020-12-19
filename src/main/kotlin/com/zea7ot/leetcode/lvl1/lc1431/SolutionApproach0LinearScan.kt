/**
 * @author: Leon
 * https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
 *
 * Time Complexity:     O(`totalKids`)
 * Space Complexity:    O(`totalKids`) / O(1)
 */
package com.zea7ot.leetcode.lvl1.lc1431

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun kidsWithCandies(candies: IntArray, extraCandies: Int): BooleanArray {
        val totalKids = candies.size
        val ans = BooleanArray(totalKids) { false }

        candies.max()?.let {
            for (idx in candies.indices) {
                if (candies[idx] + extraCandies >= it) {
                    ans[idx] = true
                }
            }
        }

        return ans
    }
}