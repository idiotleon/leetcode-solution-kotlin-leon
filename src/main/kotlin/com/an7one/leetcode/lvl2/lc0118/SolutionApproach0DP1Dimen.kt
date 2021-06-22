/**
 * https://leetcode.com/problems/pascals-triangle/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * Reference:
 *  https://leetcode.com/problems/pascals-triangle/discuss/38141/My-concise-solution-in-Java
 */
package com.an7one.leetcode.lvl2.lc0118

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DP1Dimen {
    fun generate(nRows: Int): List<List<Int>> {
        val allRows = mutableListOf<List<Int>>()

        val curRow = mutableListOf<Int>()
        for (row in 0 until nRows) {
            curRow.add(0, 1)
            for (col in 1 until curRow.size - 1) {
                curRow[col] = curRow[col] + curRow[col + 1]
            }

            allRows.add(curRow.toList())
        }

        return allRows
    }
}