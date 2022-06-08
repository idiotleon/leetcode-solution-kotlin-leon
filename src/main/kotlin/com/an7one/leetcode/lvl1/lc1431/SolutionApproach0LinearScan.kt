package com.an7one.leetcode.lvl1.lc1431

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
 *
 * Time Complexity:     O(`nKids`)
 * Space Complexity:    O(`nKids`) / O(1)
 */
@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun kidsWithCandies(candies: IntArray, extraCandies: Int): BooleanArray {
        val nKids = candies.size
        val ans = BooleanArray(nKids) { false }

        candies.maxOrNull()?.let {
            for (idx in candies.indices) {
                if (candies[idx] + extraCandies >= it)
                    ans[idx] = true
            }
        }

        return ans
    }
}