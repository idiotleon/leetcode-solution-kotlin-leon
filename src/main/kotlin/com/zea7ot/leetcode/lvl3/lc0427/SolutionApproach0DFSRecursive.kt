/**
 * https://leetcode.com/problems/construct-quad-tree/
 *
 * Time Complexity:     O((`nRows` * `nCols`) ^ 2)
 *  T(N) = 4 * T(N / 2) + N
 *
 * Space Complexity:    O((`nRows` * `nCols`) ^ 2)
 *
 * References:
 *  https://leetcode.com/problems/construct-quad-tree/discuss/151684/Recursive-Java-Solution/249595
 *  https://leetcode.com/problems/construct-quad-tree/discuss/151684/Recursive-Java-Solution
 *  https://csc411.files.wordpress.com/2012/10/tutorial2.pdf
 */
package com.zea7ot.leetcode.lvl3.lc0427

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    fun construct(grid: Array<IntArray>): QuadTreeNode? {
        val nRows = grid.size
        val nCols = grid[0].size

        return buildTree(0, 0, nRows - 1, nCols - 1, grid)
    }

    private fun buildTree(
        loRow: Int,
        loCol: Int,
        hiRow: Int,
        hiCol: Int,
        grid: Array<IntArray>
    ): QuadTreeNode? {
        if (loRow > hiRow || loCol > hiCol) return null

        if (isLeaf(loRow, loCol, hiRow, hiCol, grid))
            return QuadTreeNode(grid[loRow][loCol] == 1, true)

        val midRow = loRow + (hiRow - loRow) / 2
        val midCol = loCol + (hiCol - loCol) / 2

        val node = QuadTreeNode(`val` = false, isLeaf = false)
        node.topLeft = buildTree(loRow, loCol, midRow, midCol, grid)
        node.topRight = buildTree(loRow, 1 + midCol, midRow, hiCol, grid)
        node.bottomLeft = buildTree(1 + midRow, loCol, hiRow, midCol, grid)
        node.bottomRight = buildTree(1 + midRow, 1 + midCol, hiRow, hiCol, grid)

        return node
    }

    private fun isLeaf(loRow: Int, loCol: Int, hiRow: Int, hiCol: Int, grid: Array<IntArray>): Boolean {
        val value = grid[loRow][loCol]

        for (row in loRow..hiRow) {
            for (col in loCol..hiCol) {
                if (grid[row][col] != value) {
                    return false
                }
            }
        }

        return true
    }
}