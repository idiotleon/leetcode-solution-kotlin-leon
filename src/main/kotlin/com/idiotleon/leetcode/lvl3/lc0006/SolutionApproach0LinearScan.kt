package com.idiotleon.leetcode.lvl3.lc0006

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/zigzag-conversion/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/zigzag-conversion/discuss/3435/If-you-are-confused-with-zigzag-patterncome-and-see!/4165
 */
@Suppress(UNUSED)
class SolutionApproach0LinearScan {
    fun convert(str: String, numRows: Int): String {
        if (numRows == 1) return str

        val lenS = str.length

        val rows = List(minOf(numRows, lenS)) { StringBuilder() }

        var curRow = 0
        var increase = -1

        for (idx in str.indices) {
            if (idx % (numRows - 1) == 0) increase *= -1
            rows[curRow].append(str[idx])
            curRow += increase
        }

        val ans = StringBuilder()
        for (row in rows) ans.append(row)
        return ans.toString()
    }
}