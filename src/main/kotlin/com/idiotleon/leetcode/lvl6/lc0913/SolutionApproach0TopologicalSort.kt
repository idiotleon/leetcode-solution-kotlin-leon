package com.idiotleon.leetcode.lvl6.lc0913

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

/**
 * @author: Leon
 * https://leetcode.com/problems/cat-and-mouse/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * Reference:
 * https://leetcode.com/problems/cat-and-mouse/discuss/176177/Most-of-the-DFS-solutions-are-WRONG-check-this-case
 */
@Suppress(UNUSED)
class SolutionApproach0TopologicalSort {
    fun catMouseGame(graph: Array<IntArray>): Int {
        val nVertices = graph.size

        // [cat][mouse][mouseMove = 0]
        val colors = Array(nVertices) { Array(nVertices) { IntArray(2) { 0 } } }
        val outdegrees = Array(nVertices) { Array(nVertices) { IntArray(2) { 0 } } }
        for (idxCat in 0 until nVertices) {
            for (idxMouse in 0 until nVertices) {
                outdegrees[idxCat][idxMouse][0] = graph[idxMouse].size
                outdegrees[idxCat][idxMouse][1] = graph[idxCat].size

                for (k in graph[idxCat]) {
                    if (k == 0) {
                        --outdegrees[idxCat][idxMouse][1]
                        break
                    }
                }
            }
        }

        val queue = LinkedList<State>()
        for (idxCat in 1 until nVertices) {
            for (move in 0 until 2) {
                colors[idxCat][0][move] = 1
                queue.offer(State(idxCat, 0, move, 1)) // the mouse reaches the hole: the mouse wins
                colors[idxCat][idxCat][move] = 2
                queue.offer(State(idxCat, idxCat, move, 2)) // the cat catches the mouse: the cat wins
            }
        }

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val (idxCat, idxMouse, mouseMove, win) = queue.poll()
                if (idxCat == 2 && idxMouse == 1 && mouseMove == 0) return win

                val prevMouseMove = 1 - mouseMove
                for (prev in graph[if (prevMouseMove == 1) idxCat else idxMouse]) {
                    val prevIdxCat = if (prevMouseMove == 1) prev else idxCat
                    val prevIdxMouse = if (prevMouseMove == 1) idxMouse else prev

                    if (prevIdxCat == 0) continue
                    if (colors[prevIdxCat][prevIdxMouse][prevMouseMove] > 0) continue

                    if (prevMouseMove == 1 && win == 2 || prevMouseMove == 0 && win == 1 || --outdegrees[prevIdxCat][prevIdxMouse][prevMouseMove] == 0) {
                        colors[prevIdxCat][prevIdxMouse][prevMouseMove] = win
                        queue.offer(State(prevIdxCat, prevIdxMouse, prevMouseMove, win))
                    }
                }
            }
        }

        return colors[2][1][0]
    }

    private data class State(val idxCat: Int, val idxMouse: Int, val mouseMove: Int, val turn: Int)
}