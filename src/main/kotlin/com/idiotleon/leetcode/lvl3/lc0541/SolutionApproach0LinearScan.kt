package com.idiotleon.leetcode.lvl3.lc0541

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/reverse-string-ii/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(`lenS`)
 *
 * Reference:
 * https://leetcode.com/problems/reverse-string-ii/discuss/100866/Java-Concise-Solution
 */
@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun reverseStr(s: String, k: Int): String {
        val lenS = s.length

        val chs = s.toCharArray()
        var lo = 0
        while (lo < lenS) {
            val hi = minOf(lo + k - 1, lenS - 1)
            reverse(lo, hi, chs)
            lo += 2 * k
        }

        return String(chs)
    }

    private fun reverse(low: Int, high: Int, chs: CharArray) {
        var lo = low
        var hi = high

        while (lo < hi) swap(lo++, hi--, chs)
    }

    private fun swap(lo: Int, hi: Int, chs: CharArray) {
        val temp = chs[lo]
        chs[lo] = chs[hi]
        chs[hi] = temp
    }
}