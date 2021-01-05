/**
 * https://leetcode.com/problems/count-number-of-teams/
 *
 * Time Complexity:     O(`nRatings`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/count-number-of-teams/discuss/554795/C++Java-O(n-*-n)-and-O(n-log-n)/529400
 *  https://leetcode.com/problems/count-number-of-teams/discuss/554795/C%2B%2BJava-O(n-*-n)-and-O(n-log-n)
 */
package com.zea7ot.leetcode.lvl3.lc1395

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0ThreePointers {
    fun numTeams(ratings: IntArray): Int {
        val nRatings = ratings.size
        if (nRatings < 3) return 0

        var count = 0

        var i = 0
        var j = 1
        var k = 2

        while (i < nRatings - 2) {
            if (ratings[i] < ratings[j] && ratings[j] < ratings[k]) {
                ++count
            }

            if (ratings[i] > ratings[j] && ratings[j] > ratings[k]) {
                ++count
            }

            when {
                k == nRatings - 1 && j == nRatings - 2 -> {
                    ++i
                    j = i + 1
                    k = i + 2
                }

                k == nRatings - 1 -> {
                    ++j
                    k = j + 1
                }

                else -> ++k
            }
        }

        return count
    }
}