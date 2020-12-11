/**
 * https://leetcode.com/problems/frog-position-after-t-seconds/
 *
 * Time Complexity:     O(`n`)
 * Space Complexity:    O(`n`)
 *
 * References:
 *  https://leetcode.com/problems/frog-position-after-t-seconds/discuss/532571/JavaC++Python-DFS/473149
 *  https://leetcode.com/problems/frog-position-after-t-seconds/discuss/532571/JavaC%2B%2BPython-DFS
 */
package com.zea7ot.leetcode.lvl4.lc1377

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0DFS {
    class Solution {
        fun frogPosition(n: Int, edges: Array<IntArray>, t: Int, target: Int): Double {
            if (n == 1) return 1.0

            val graph = buildGraph(n, edges)
            val visited = BooleanArray(n + 1) { false }
            return dfs(0, t, 1.0, target - 1, visited, graph)
        }

        private fun dfs(cur: Int,
                        time: Int,
                        probability: Double,
                        target: Int,
                        visited: BooleanArray,
                        graph: Array<ArrayList<Int>>): Double {
            val size = graph[cur].size

            if (cur != 0 && size == 1 || time == 0) {
                if (cur == target) return probability
                return 0.0
            }

            visited[cur] = true

            for (next in graph[cur]) {
                if (visited[next]) continue
                val totalVertices = size - if (cur == 0) 0 else 1
                val res = dfs(next, time - 1, probability / totalVertices, target, visited, graph)

                if (res != 0.0) return res
            }

            return 0.0
        }

        private fun buildGraph(n: Int, edges: Array<IntArray>): Array<ArrayList<Int>> {
            val graph = Array(n + 1) { arrayListOf<Int>() }

            for (edge in edges) {
                val (u, v) = edge

                // to turn into 0-indexed
                graph[u - 1].add(v - 1)
                graph[v - 1].add(u - 1)
            }

            return graph
        }
    }
}