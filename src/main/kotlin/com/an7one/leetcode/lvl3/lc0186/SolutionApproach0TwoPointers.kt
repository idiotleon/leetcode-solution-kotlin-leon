package com.an7one.leetcode.lvl3.lc0186

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/reverse-words-in-a-string-ii/
 *
 * Time Complexity:     O(`nChs`)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class SolutionApproach0TwoPointers {
    private companion object {
        private const val CH_SPACE = ' '
    }

    fun reverseWords(chs: CharArray) {
        if (chs.isEmpty()) return

        val nChs = chs.size
        reverse(0, nChs - 1, chs)

        var lo = 0
        var hi = 0

        while (hi < nChs) {
            while (hi < nChs && chs[hi] != CH_SPACE) ++hi

            reverse(lo, hi - 1, chs)
            lo = hi + 1

            ++hi
        }
    }

    fun reverse(lo: Int, hi: Int, chs: CharArray) {
        var lo = lo
        var hi = hi
        while (lo < hi) {
            swap(lo, hi, chs)

            ++lo
            --hi
        }
    }

    fun swap(i: Int, j: Int, chs: CharArray) {
        val temp = chs[i]
        chs[i] = chs[j]
        chs[j] = temp
    }
}