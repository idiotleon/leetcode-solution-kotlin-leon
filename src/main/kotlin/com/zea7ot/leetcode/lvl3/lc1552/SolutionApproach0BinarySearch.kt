/**
 * https://leetcode.com/problems/magnetic-force-between-two-balls/
 *
 * Time Complexity:     O(`totalPos` * lg(`positions.last() - positions.first()`))
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/magnetic-force-between-two-balls/discuss/794070/Python-Binary-search-solution-with-explanation-and-similar-questions/657446
 *  https://leetcode.com/problems/magnetic-force-between-two-balls/discuss/794070/Python-Binary-search-solution-with-explanation-and-similar-questions
 */
package com.zea7ot.leetcode.lvl3.lc1552

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BinarySearch {
    class Solution {
        fun maxDistance(positions: IntArray, m: Int): Int {
            // not used
            // val totalPos = positions.size
            positions.sort()

            var lo = 0
            var hi = positions.last() - positions.first()

            while (lo < hi) {
                val mid = hi - (hi - lo) / 2
                if (getCount(mid, positions) >= m) {
                    lo = mid
                } else {
                    hi = mid - 1
                }
            }

            return lo
        }

        private fun getCount(minDistance: Int, positions: IntArray): Int {
            val totalPos = positions.size

            var count = 1
            var cur = positions.first()
            for (idx in 1 until totalPos) {
                if (positions[idx] - cur >= minDistance) {
                    ++count
                    cur = positions[idx]
                }
            }

            return count
        }
    }
}