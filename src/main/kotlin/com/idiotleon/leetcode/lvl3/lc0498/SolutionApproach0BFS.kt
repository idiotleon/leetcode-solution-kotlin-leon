/**
 * https://leetcode.com/problems/diagonal-traverse/
 *
 * Time Complexity:     O(`nRows` * `nCols`)
 * Space Complexity:    O(`nRows` * `nCols`)
 *
 * Reference:
 * https://leetcode.com/problems/diagonal-traverse/discuss/97711/Java-15-lines-without-using-boolean/159357
 */
package com.idiotleon.leetcode.lvl3.lc0498

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import kotlin.collections.ArrayDeque
import kotlin.collections.HashMap

@Suppress(UNUSED)
class SolutionApproach0BFS {
    @OptIn(ExperimentalStdlibApi::class)
    fun findDiagonalOrder(matrix: Array<IntArray>): IntArray {
        // sanity check
        if (matrix.isEmpty()) return intArrayOf()

        val nRows = matrix.size
        val nCols = matrix[0].size

        val levelToNums = HashMap<Int, ArrayDeque<Int>>()
        for (row in matrix.indices) {
            for (col in matrix[row].indices) {
                val lvl = row + col
                val level = levelToNums.getOrPut(lvl) { ArrayDeque() }

                if (lvl % 2 == 0) {
                    level.addFirst(matrix[row][col])
                } else {
                    level.addLast(matrix[row][col])
                }
            }
        }

        val ans = IntArray(nRows * nCols) { 0 }
        var idx = 0
        for ((_, nums) in levelToNums) {
            for (num in nums) {
                ans[idx++] = num
            }
        }

        return ans
    }
}