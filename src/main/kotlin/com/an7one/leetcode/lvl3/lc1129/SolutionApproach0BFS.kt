package com.an7one.leetcode.lvl3.lc1129

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import java.util.*
import kotlin.collections.HashSet

/**
 * @author: Leon
 * https://leetcode.com/problems/shortest-path-with-alternating-colors/
 *
 * Time Complexity:     O(V + E)
 * Space Complexity:    O(V + E)
 *
 * References:
 *  https://leetcode.com/problems/shortest-path-with-alternating-colors/discuss/340258/Java-BFS-Solution-with-Video-Explanation
 */
@Suppress(UNUSED)
class SolutionApproach0BFS {
    private companion object {
        private const val COLOR_RED = 1
        private const val COLOR_BLUE = -1
        private const val COLOR_BOTH = 0

        private const val NOT_EXISTS = -1
    }

    fun shortestAlternatingPaths(n: Int, redEdges: Array<IntArray>, blueEdges: Array<IntArray>): IntArray {
        val ans = IntArray(n) { idx -> if (idx == 0) 0 else Int.MAX_VALUE }

        val graph = buildGraph(redEdges, blueEdges, n)

        val queue = ArrayDeque<Node>().also {
            it.addLast(Node(0, COLOR_RED))
            it.addLast(Node(0, COLOR_BLUE))
        }

        // shortest path, or BFS level
        var shortest = 1

        val seen = HashSet<String>()

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (i in 0 until size) {
                val cur = queue.removeFirst()
                val curNode = cur.node
                val color = cur.color
                val hash = "$curNode#$color"
                if (!seen.add(hash)) continue

                val otherColor = -color

                for (nextNode in 1 until n) {
                    if (graph[curNode][nextNode] != otherColor && graph[curNode][nextNode] != COLOR_BOTH) continue
                    // or equivalently in terms of skipping visited nodes
                    // val hash = "$nextNode#$otherColor"
                    // if(!seen.add(hash)) continue
                    queue.addLast(Node(nextNode, otherColor))
                    ans[nextNode] = minOf(ans[nextNode], shortest)
                }
            }

            ++shortest
        }

        for (idx in 1 until n) {
            if (ans[idx] == Int.MAX_VALUE) {
                ans[idx] = NOT_EXISTS
            }
        }

        return ans
    }

    private fun buildGraph(redEdges: Array<IntArray>, blueEdges: Array<IntArray>, n: Int): Array<IntArray> {
        val graph = Array(n) { IntArray(n) { -n } }

        for (edge in redEdges) {
            val from = edge[0]
            val to = edge[1]
            graph[from][to] = COLOR_RED
        }

        for (edge in blueEdges) {
            val from = edge[0]
            val to = edge[1]

            graph[from][to] = if (graph[from][to] == COLOR_RED) {
                COLOR_BOTH
            } else {
                COLOR_BLUE
            }

            if (graph[from][to] == COLOR_RED) {
                graph[from][to] = COLOR_BOTH
            } else {
                graph[from][to] = COLOR_BLUE
            }
        }

        return graph
    }

    private data class Node(val node: Int, val color: Int)
}