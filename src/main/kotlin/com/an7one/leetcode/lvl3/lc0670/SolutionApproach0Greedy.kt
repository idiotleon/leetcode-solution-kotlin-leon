/**
 * https://leetcode.com/problems/maximum-swap/
 *
 * Time Complexity:     O(`lenD`)
 * Space Complexity:    O(`lenD`)
 *
 * Reference:
 *  https://leetcode.com/problems/maximum-swap/discuss/107068/Java-simple-solution-O(n)-time
 */
package com.an7one.leetcode.lvl3.lc0670

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Greedy {
    fun maximumSwap(num: Int): Int {
        val digits = num.toString().toCharArray()
        val lenD = digits.size

        val nextMaxIndices = IntArray(lenD) { 0 }
        var maxIdx = lenD - 1

        for (idx in lenD - 1 downTo 0) {
            nextMaxIndices[idx] = maxIdx
            if (digits[maxIdx] - '0' < digits[idx] - '0')
                maxIdx = idx
        }

        for (idx in digits.indices) {
            if (digits[idx] - '0' < digits[nextMaxIndices[idx]] - '0') {
                swap(idx, nextMaxIndices[idx], digits)
                break
            }
        }

        return String(digits).toInt()
    }

    private fun swap(i: Int, j: Int, chs: CharArray) {
        val temp = chs[i]
        chs[i] = chs[j]
        chs[j] = temp
    }
}