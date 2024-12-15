package com.idiotleon.leetcode.lvl4.lc0556

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/next-greater-element-iii/
 *
 * Time Complexity:     O(`n`) ~ O(1)
 * Space Complexity:    O(`n`) ~ O(1)
 *
 * Reference:
 * https://leetcode.com/problems/next-greater-element-iii/discuss/101824/Simple-Java-solution-(4ms)-with-explanation./105491
 */
@Suppress(UNUSED)
class SolutionApproach0ParsingString {
    fun nextGreaterElement(n: Int): Int {
        val chs = n.toString().toCharArray()
        val nChs = chs.size

        var lo = nChs - 2
        while (lo >= 0 && chs[lo] >= chs[lo + 1]) {
            --lo
        }
        if (lo < 0) {
            return -1
        }

        var hi = nChs - 1
        while (chs[hi] <= chs[lo]) {
            --hi
        }

        swap(lo, hi, chs)
        reverse(lo + 1, nChs - 1, chs)

        return try {
            String(chs).toInt()
        } catch (ex: Exception) {
            -1
        }
    }

    private fun reverse(low: Int, high: Int, chs: CharArray) {
        var lo = low
        var hi = high

        while (lo < hi) {
            swap(lo++, hi--, chs)
        }
    }

    private fun swap(i: Int, j: Int, chs: CharArray) {
        val temp = chs[i]
        chs[i] = chs[j]
        chs[j] = temp
    }
}