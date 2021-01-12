/**
 * https://leetcode.com/problems/zigzag-conversion/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/zigzag-conversion/discuss/3403/Easy-to-understand-Java-solution/112090
 */
package com.zea7ot.leetcode.lvl3.lc0006

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0LinearScan1 {
    fun convert(str: String, numRows: Int): String {
        if (numRows == 1) return str

        val lenS = str.length

        val rows = List(minOf(numRows, lenS)) { StringBuilder() }

        var curRow = 0
        var goingDown = false

        for (ch in str) {
            rows[curRow].append(ch)
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = goingDown.not()
            }

            curRow += if (goingDown) 1 else -1
        }

        val ans = StringBuilder()
        for (row in rows) ans.append(row)
        return ans.toString()
    }
}