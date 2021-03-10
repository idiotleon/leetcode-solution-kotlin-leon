/**
 * https://leetcode.com/problems/construct-quad-tree/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * References:
 *  https://leetcode.com/problems/construct-quad-tree/discuss/154565/Java-recursive-solution
 */
package com.an7one.leetcode.lvl3.lc0427

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive1 {
    fun construct(grid: Array<IntArray>): QuadTreeNode {
        val nRows = grid.size

        return dfs(0, 0, nRows, grid)
    }

    private fun dfs(row: Int, col: Int, len: Int, grid: Array<IntArray>): QuadTreeNode {
        if (len == 1) {
            return QuadTreeNode(grid[row][col] != 0, true)
        }

        val root = QuadTreeNode(`val` = false, isLeaf = false)
        val topLeft = dfs(row, col, len / 2, grid)
        val topRight = dfs(row, col + len / 2, len / 2, grid)
        val bottomLeft = dfs(row + len / 2, col, len / 2, grid)
        val bottomRight = dfs(row + len / 2, col + len / 2, len / 2, grid)

        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf
            && topLeft.`val` == topRight.`val`
            && topRight.`val` == bottomLeft.`val`
            && bottomLeft.`val` == bottomRight.`val`
        ) {
            root.isLeaf = true
            root.`val` = topLeft.`val`
        } else {
            root.topLeft = topLeft
            root.topRight = topRight
            root.bottomLeft = bottomLeft
            root.bottomRight = bottomRight
        }

        return root
    }
}