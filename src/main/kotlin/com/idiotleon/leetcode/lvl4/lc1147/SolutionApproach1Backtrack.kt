/**
 * https://leetcode.com/problems/longest-chunked-palindrome-decomposition/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/longest-chunked-palindrome-decomposition/discuss/350560/JavaC++Python-Easy-Greedy-with-Prove/317828
 */
package com.idiotleon.leetcode.lvl4.lc1147

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach1Backtrack {
    private var longest = 0

    fun longestDecomposition(text: String): Int {
        val lenT = text.length

        backtrack(0, lenT - 1, 0, text)

        return longest
    }

    private fun backtrack(lo: Int, hi: Int, k: Int, str: String) {
        if (lo > hi + 1) return
        if (lo == hi + 1) {
            longest = maxOf(longest, k)
            return
        }

        val len = hi - lo
        for (idx in 1..len) {
            if (str.substring(lo, lo + idx) == str.substring(hi - idx + 1, 1 + hi)) {
                backtrack(lo + idx, hi - idx, k + 2, str)
                break
            }
        }

        longest = maxOf(longest, k + 1)
    }
}