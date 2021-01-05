/**
 * https://leetcode.com/problems/count-number-of-teams/
 *
 * Time Complexity:     O(`nRatings` ^ 2)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/count-number-of-teams/discuss/555441/JavaC%2B%2B-100-O(N2)-Easy-To-Understand-With-Explanation
 */
package com.zea7ot.leetcode.lvl3.lc1395

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0ThreePointers1 {
    fun numTeams(ratings: IntArray): Int {
        val nRatings = ratings.size

        var count = 0

        for (mid in ratings.indices) {
            var loSmaller = 0
            var loLarger = 0

            var hiSmaller = 0
            var hiLarger = 0

            for (lo in 0 until mid) {
                when {
                    ratings[lo] < ratings[mid] -> ++loSmaller
                    ratings[lo] > ratings[mid] -> ++loLarger
                }
            }

            for (hi in mid + 1 until nRatings) {
                when {
                    ratings[mid] < ratings[hi] -> ++hiLarger
                    ratings[mid] > ratings[hi] -> ++hiSmaller
                }
            }

            count += loSmaller * hiLarger + loLarger * hiSmaller
        }

        return count
    }
}