/**
 * https://leetcode.com/problems/reverse-words-in-a-string-ii/
 *
 * Time Complexity:     O(L)
 * Space Complexity:    O(1)
 */
package com.an7one.leetcode.lvl3.lc0186

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0TwoPointers {
    fun reverseWords(chs: CharArray): Unit {
        if (chs.isEmpty()) return

        val size = chs.size
        reverse(0, size - 1, chs)

        var lo = 0
        var hi = 0

        while (hi < size) {
            while (hi < size && chs[hi] != ' ') ++hi

            reverse(lo, hi - 1, chs)
            lo = hi + 1

            ++hi
        }
    }

    fun reverse(LO: Int, HI: Int, chs: CharArray): Unit {
        var lo = LO
        var hi = HI
        while (lo < hi)
            swap(lo++, hi--, chs)
    }

    fun swap(i: Int, j: Int, chs: CharArray): Unit {
        val temp = chs[i]
        chs[i] = chs[j]
        chs[j] = temp
    }
}