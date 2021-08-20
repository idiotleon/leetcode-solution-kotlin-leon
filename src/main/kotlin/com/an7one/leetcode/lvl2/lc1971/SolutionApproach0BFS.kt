/**
 * @author: Leon
 * https://leetcode.com/problems/find-if-path-exists-in-graph/
 *
 * Time Complexity:     O(V + E) ~ O(`n` + `nEdges`)
 * Space Complexity:    O(V + E) ~ O(`n` + `nEdges`)
 */
package com.an7one.leetcode.lvl2.lc1971

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0BFS {
    @OptIn(ExperimentalStdlibApi::class)
    fun validPath(n: Int, edges: Array<IntArray>, start: Int, end: Int): Boolean {
        val graph = buildGraph(n, edges)

        val queue = ArrayDeque<Int>().also {
            it.addLast(start)
        }

        val seen = HashSet<Int>().also {
            it.add(start)
        }

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val cur = queue.removeFirst()
                if (cur == end)
                    return true

                for (next in graph[cur]) {
                    if (seen.add(next))
                        queue.addLast(next)
                }
            }
        }

        return false
    }

    private fun buildGraph(n: Int, edges: Array<IntArray>): List<HashSet<Int>> {
        val graph = MutableList(n) { hashSetOf<Int>() }

        for ((u, v) in edges) {
            graph[u].add(v)
            graph[v].add(u)
        }

        return graph
    }
}