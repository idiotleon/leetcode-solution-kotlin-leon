/**
 * @author: Leon
 * https://leetcode.com/problems/reverse-only-letters/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
package com.an7one.leetcode.lvl1.lc0917

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0HighLowPointers {
    fun reverseOnlyLetters(str: String): String {
        // not used
        // val lenS = str.length

        val chs = str.toCharArray()

        var lo = 0
        var hi = chs.lastIndex

        while (lo < hi) {
            while (lo < hi && !isLetter(chs[lo])) ++lo
            while (lo < hi && !isLetter(chs[hi])) --hi

            swap(lo++, hi--, chs)
        }

        return String(chs)
    }

    private fun swap(lo: Int, hi: Int, chs: CharArray) {
        val temp = chs[lo]
        chs[lo] = chs[hi]
        chs[hi] = temp
    }

    private fun isLetter(ch: Char) = ch in 'a'..'z' || ch in 'A'..'Z'
}