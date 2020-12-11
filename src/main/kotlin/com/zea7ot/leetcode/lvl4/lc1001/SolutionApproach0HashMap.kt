/**
 * https://leetcode.com/problems/grid-illumination/
 *
 * Time Complexity:     O(`totalLamps`) + O(`totalQueries`)
 * Space Complexity:    O(`totalLamps`)
 *
 * References:
 *  https://leetcode.com/problems/grid-illumination/discuss/243076/Java-Clean-Code-O(N)-Time-and-O(N)-Space-Beats-100
 */
package com.zea7ot.leetcode.lvl4.lc1001

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0HashMap {
    private companion object {
        private val DIRS = arrayOf(intArrayOf(0, 1), intArrayOf(0, -1),
                intArrayOf(1, 0), intArrayOf(-1, 0),
                intArrayOf(1, 1), intArrayOf(1, -1),
                intArrayOf(-1, 1), intArrayOf(-1, -1),
                intArrayOf(0, 0))
    }

    fun gridIllumination(N: Int,
                         lamps: Array<IntArray>,
                         queries: Array<IntArray>): IntArray {
        val totalQueries = queries.size
        // not used
        // val totalLamps = lamps.size

        val rowMap = HashMap<Int, Int>()
        val colMap = HashMap<Int, Int>()
        val diagMap = HashMap<Int, Int>()
        val antiDiagMap = HashMap<Int, Int>()
        val lightOnMap = HashMap<Int, Boolean>()

        for (lamp in lamps) {
            val row = lamp[0]
            val col = lamp[1]

            rowMap[row] = (rowMap[row] ?: 0) + 1
            colMap[col] = (colMap[col] ?: 0) + 1
            diagMap[row - col] = (diagMap[row - col] ?: 0) + 1
            antiDiagMap[row + col] = (antiDiagMap[row + col] ?: 0) + 1
            lightOnMap[N * row + col] = true
        }

        val ans = IntArray(totalQueries) { 0 }
        var idx = 0
        for (query in queries) {
            val row = query[0]
            val col = query[1]

            ans[idx++] = if ((rowMap[row] ?: 0) > 0 || (colMap[col] ?: 0) > 0 || (diagMap[row - col]
                            ?: 0) > 0 || (antiDiagMap[row + col] ?: 0) > 0) 1 else 0

            for (d in DIRS.indices) {
                val newRow = row + DIRS[d][0]
                val newCol = col + DIRS[d][1]

                if (lightOnMap[N * newRow + newCol] ?: false) {
                    rowMap[newRow] = (rowMap[newRow] ?: 0) - 1
                    colMap[newCol] = (colMap[newCol] ?: 0) - 1
                    diagMap[newRow - newCol] = (diagMap[newRow - newCol] ?: 0) - 1
                    antiDiagMap[newRow + newCol] = (antiDiagMap[newRow + newCol] ?: 0) - 1
                    lightOnMap[N * newRow + newCol] = false
                }
            }
        }

        return ans
    }
}