/**
 * https://leetcode.com/problems/palindrome-partitioning-ii/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * `cuts[i]`, the minimum number of cuts of a substring. The number of cuts of substring[0, i - 1]
 *
 * References:
 *  https://leetcode.com/problems/palindrome-partitioning-ii/discuss/42198/My-solution-does-not-need-a-table-for-palindrome-is-it-right-It-uses-only-O(n)-space./40522
 *  https://leetcode.com/problems/palindrome-partitioning-ii/discuss/42198/My-solution-does-not-need-a-table-for-palindrome-is-it-right-It-uses-only-O(n)-space./112629
 *  https://leetcode.com/problems/palindrome-partitioning-ii/discuss/42198/My-solution-does-not-need-a-table-for-palindrome-is-it-right-It-uses-only-O(n)-space.
 */
package com.zea7ot.leetcode.lvl4.lc0132

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun minCut(str: String): Int {
        val lenS = str.length
        val cuts = IntArray(lenS + 1) { idx -> idx - 1 }

        for (hi in str.indices) {
            var lo = 0
            while (hi - lo >= 0 && lo + hi < lenS && str[hi - lo] == str[hi + lo]) { // palindrome of odd lengths
                cuts[lo + hi + 1] = minOf(cuts[lo + hi + 1], 1 + cuts[hi - lo])
                ++lo
            }

            lo = 1
            while (hi - lo + 1 >= 0 && lo + hi < lenS && str[hi - lo + 1] == str[hi + lo]) { // palindrome of even lengths
                cuts[lo + hi + 1] = minOf(cuts[lo + hi + 1], 1 + cuts[hi - lo + 1])
                ++lo
            }
        }

        return cuts[lenS]
    }
}