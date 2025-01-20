package com.idiotleon.leetcode.lvl2.lc2661

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/first-completely-painted-row-or-column/
 *
 * Time Complexity:     O(`nRows` * `nCols`)
 * Space Complexity:    O(`nRows` * `nCols`)
 */
@Suppress(UNUSED)
class Solution0HashMap {
    fun firstCompleteIndex(nums: IntArray, matrix: Array<IntArray>): Int {
        val nRows = matrix.size
        val nCols = matrix[0].size

        // num to coordination
        val numToNode = HashMap<Int, Node>().also {
            for (r in 0 until nRows) {
                for (c in 0 until nCols) {
                    it[matrix[r][c]] = Node(r, c)
                }
            }
        }

        val numToCols = HashMap<Int, MutableList<Int>>()
        val numToRows = HashMap<Int, MutableList<Int>>()
        for ((idx, num) in nums.withIndex()) {
            numToNode[num]?.let { (r, c) ->
                val cols = numToCols.getOrPut(r) { mutableListOf() }
                cols.add(c)
                if (cols.size == nCols) {
                    return idx
                }

                val rows = numToRows.getOrPut(c) { mutableListOf() }
                rows.add(r)
                if (rows.size == nRows) {
                    return idx
                }
            }
        }

        throw UnsupportedOperationException()
    }

    // coordination
    private data class Node(val r: Int, val c: Int)
}