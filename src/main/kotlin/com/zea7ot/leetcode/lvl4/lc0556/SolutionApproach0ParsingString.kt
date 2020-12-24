/**
 * https://leetcode.com/problems/next-greater-element-iii/
 *
 * Time Complexity:     O(`n`)
 * Space Complexity:    O(`n`)
 *
 * References:
 *  https://leetcode.com/problems/next-greater-element-iii/discuss/101824/Simple-Java-solution-(4ms)-with-explanation./105491
 */
package com.zea7ot.leetcode.lvl4.lc0556

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0ParsingString {
    fun nextGreaterElement(n: Int): Int {
        val chs = n.toString().toCharArray()
        val nChs = chs.size

        var i = nChs - 2
        while (i >= 0 && chs[i] >= chs[i + 1]) --i
        if (i < 0) return -1

        var j = nChs - 1
        while (chs[j] <= chs[i]) --j

        swap(i, j, chs)
        reverse(i + 1, nChs - 1, chs)

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