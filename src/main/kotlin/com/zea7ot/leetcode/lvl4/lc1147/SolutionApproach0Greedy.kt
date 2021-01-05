/**
 * https://leetcode.com/problems/longest-chunked-palindrome-decomposition/
 *
 * Time Complexity:     O(`lenT` ^ 2)
 * Space Complexity:    O(`lenT`)
 *
 * References:
 *  https://leetcode.com/problems/longest-chunked-palindrome-decomposition/discuss/350560/JavaC++Python-Easy-Greedy-with-Prove/318607
 *  https://leetcode.com/problems/longest-chunked-palindrome-decomposition/discuss/350560/JavaC%2B%2BPython-Easy-Greedy-with-Prove
 */
package com.zea7ot.leetcode.lvl4.lc1147

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Greedy {
    fun longestDecomposition(text: String): Int {
        val lenT = text.length

        var count = 0

        var lo = ""
        var hi = ""

        for (idx in 0 until lenT / 2) {
            lo = lo + text[idx]
            hi = text[lenT - idx - 1] + hi

            if (lo == hi) {
                count += 2
                lo = ""
                hi = ""
            }
        }

        return if (lenT % 2 == 0 && lo == "" && hi == "") count
        else count + 1
    }
}