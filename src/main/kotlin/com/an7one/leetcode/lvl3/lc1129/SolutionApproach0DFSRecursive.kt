package com.an7one.leetcode.lvl3.lc1129

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/shortest-path-with-alternating-colors/
 *
 * Time Complexity:     O(V + E)
 * Space Complexity:    O(V + E)
 *
 * Reference:
 * https://leetcode.com/problems/shortest-path-with-alternating-colors/discuss/340246/Java-DFS-and-BFS-two-codes-each-wo-duplication-check.
 */
@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    private companion object {
        private const val COLOR_RED = 0
        private const val COLOR_BLUE = 1

        private const val NOT_EXIST = -1
    }

    fun shortestAlternatingPaths(n: Int, redEdges: Array<IntArray>, blueEdges: Array<IntArray>): IntArray {
        val paths = Array(2) { IntArray(n) { idx -> if (idx == 0) 0 else Int.MAX_VALUE } }

        dfs(0, COLOR_RED, 0, redEdges, blueEdges, paths)
        dfs(0, COLOR_BLUE, 0, redEdges, blueEdges, paths)

        // to get the shorter one with regard to both colors
        for (idx in 1 until n) {
            val shorter = minOf(paths[COLOR_RED][idx], paths[COLOR_BLUE][idx])
            paths[0][idx] = if (shorter == Int.MAX_VALUE) NOT_EXIST else shorter
        }

        return paths[0]
    }

    private fun dfs(
        cur: Int,
        curColor: Int,
        steps: Int,
        redEdges: Array<IntArray>,
        blueEdges: Array<IntArray>,
        paths: Array<IntArray>
    ) {
        val edges = if (curColor == COLOR_RED) redEdges else blueEdges
        val otherColor = if (curColor == COLOR_RED) COLOR_BLUE else COLOR_RED

        for (edge in edges) {
            val from = edge[0]
            val to = edge[1]

            if (from == cur && paths[otherColor][to] > 1 + steps) {
                paths[otherColor][to] = 1 + steps
                dfs(to, otherColor, 1 + steps, redEdges, blueEdges, paths)
            }
        }
    }
}