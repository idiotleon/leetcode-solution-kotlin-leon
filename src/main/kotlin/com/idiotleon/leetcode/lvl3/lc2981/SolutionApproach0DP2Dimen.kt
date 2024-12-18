package com.idiotleon.leetcode.lvl3.lc2981

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/find-longest-special-substring-that-occurs-thrice-i/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/find-longest-special-substring-that-occurs-thrice-i/solutions/4481194/c-java-python-javascript-easy-implementation-explained/comments/2287551
 */
@Suppress(UNUSED)
class SolutionApproach0DP2Dimen {
    fun maximumLength(s: String): Int {
        val lenS = s.length
        val freqs = Array(26) { IntArray(lenS + 1) { 0 } }
        var max = 0

        var lo = 0
        while (lo < lenS) {
            var hi = lo
            while (hi < lenS - 1 && s[lo] == s[hi + 1]) {
                ++hi
            }

            val window = hi - lo + 1
            for (len in 1..window) {
                val freq = window - len + 1
                val chIdx = s[lo] - 'a'
                freqs[chIdx][len] += freq
                val count = freqs[chIdx][len]
                // .let{
                if (count >= 3) {
                    max = maxOf(max, len)
                }
                // }
            }
            lo = hi + 1
            // ++lo
        }

        return if (max == 0) {
            -1
        } else {
            max
        }
    }
}