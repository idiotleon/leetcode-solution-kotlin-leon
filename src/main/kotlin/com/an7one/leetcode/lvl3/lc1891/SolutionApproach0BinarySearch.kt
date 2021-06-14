/**
 * https://leetcode.com/problems/cutting-ribbons/
 *
 * Time Complexity:     O(lg(`sum`))
 * Space Complexity:    O(1)
 *
 * Reference:
 *  https://leetcode.com/problems/cutting-ribbons/discuss/1263437/Java-Simple-Binary-Search-%2B-Explanation
 */
package com.an7one.leetcode.lvl3.lc1891

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BinarySearch {
    fun maxLength(ribbons: IntArray, k: Int): Int {
        val sum = ribbons.map { it.toLong() }.sum()

        var lo = 1L
        var hi = sum

        while (lo < hi) {
            val mid = lo + (hi - lo) / 2

            if (!isCutEligible(ribbons, mid, k))
                hi = mid
            else
                lo = mid + 1
        }

        return lo.toInt() - 1
    }

    private fun isCutEligible(ribbons: IntArray, lenCut: Long, k: Int): Boolean {
        var count = 0

        for (ribbon in ribbons) {
            count += ribbon / lenCut.toInt()
        }

        return count >= k
    }
}