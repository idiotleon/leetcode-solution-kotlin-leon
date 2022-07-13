package com.an7one.leetcode.lvl6.lc0913

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * this is NOT a correct solution, because it fails to detect cycles
 * https://leetcode.com/problems/cat-and-mouse/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * Reference:
 * https://leetcode.com/problems/cat-and-mouse/discuss/181681/Java-solution-with-bug-updated-on-02022019
 * https://leetcode.com/problems/cat-and-mouse/discuss/176268/Perfect-Wrong-DFSDP-code-explained-in-detail-(Revised)
 */
@Suppress(UNUSED)
class SolutionApproach4DFSMemo {
    private companion object {
        private const val DRAW = 0
        private const val MOUSE_WINS = 1
        private const val CAT_WINS = 2
    }

    fun catMouseGame(graph: Array<IntArray>): Int {
        val nVertices = graph.size

        val memo = Array(nVertices) { Array<Int?>(nVertices) { null } }
        for (idx in 1 until nVertices) {
            memo[0][idx] = MOUSE_WINS // the mouse reaches the hole: the mouse wins
            memo[idx][idx] = CAT_WINS // the cat catches the mouse: the cat wins
        }

        return dfs(1, 2, graph, memo)
    }

    private fun dfs(
        mouse: Int, cat: Int, graph: Array<IntArray>, memo: Array<Array<Int?>>
    ): Int {

        memo[mouse][cat]?.let { return it }

        memo[mouse][cat] = 0
        var mouseDefault = CAT_WINS
        val mouseMoves = graph[mouse]
        val catMoves = graph[cat]

        for (mouseMove in mouseMoves) {
            if (mouseMove == cat) continue

            var catDefault = MOUSE_WINS
            for (catMove in catMoves) {
                if (catMove == 0) continue

                val next = dfs(mouseMove, catMove, graph, memo)
                if (next == CAT_WINS) {
                    catDefault = CAT_WINS
                    break
                }
                if (next == DRAW) {
                    catDefault = DRAW
                }
            }

            if (catDefault == MOUSE_WINS) {
                mouseDefault = MOUSE_WINS
            }

            if (catDefault == DRAW) {
                mouseDefault = DRAW
            }
        }

        memo[mouse][cat] = mouseDefault
        return mouseDefault
    }
}