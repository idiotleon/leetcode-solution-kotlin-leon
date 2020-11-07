/**
 * https://leetcode.com/problems/reverse-string-ii/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(`lenS`)
 *
 * References:
 *  https://leetcode.com/problems/reverse-string-ii/discuss/100866/Java-Concise-Solution/104784
 */
package com.zea7ot.leetcode.lvl3.lc0541

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan1 {
    fun reverseStr(s: String, k: Int): String {
        // not used
        // val lenS = s.length

        val chs = s.toCharArray()
        for (idx in chs.indices step 2 * k) {
            reverse(idx, idx + k, chs)
        }

        return String(chs)
    }

    private fun reverse(low: Int, high: Int, chs: CharArray) {
        val lenS = chs.size

        var lo = low
        var hi = minOf(lenS, high) - 1

        while (lo < hi) swap(lo++, hi--, chs)
    }

    private fun swap(lo: Int, hi: Int, chs: CharArray) {
        val temp = chs[lo]
        chs[lo] = chs[hi]
        chs[hi] = temp
    }
}