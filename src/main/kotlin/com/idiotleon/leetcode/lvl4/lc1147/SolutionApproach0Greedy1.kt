/**
 * https://leetcode.com/problems/longest-chunked-palindrome-decomposition/
 *
 * Time Complexity:     O(`lenT` ^ 2)
 * Space Complexity:    O(`lenT`)
 *
 * References:
 *  https://leetcode.com/problems/longest-chunked-palindrome-decomposition/discuss/350560/JavaC%2B%2BPython-Easy-Greedy-with-Prove
 */
package com.idiotleon.leetcode.lvl4.lc1147

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Greedy1 {
    fun longestDecomposition(text: String): Int {
        val lenT = text.length

        var count = 0

        var lo = ""
        var hi = ""

        for (idx in text.indices) {
            lo = lo + text[idx]
            hi = text[lenT - idx - 1] + hi

            if (lo == hi) {
                ++count
                lo = ""
                hi = ""
            }
        }

        return count
    }
}