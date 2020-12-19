/**
 * https://leetcode.com/problems/frog-position-after-t-seconds/
 *
 * Time Complexity:     O(`n`)
 * Space Complexity:    O(`n`)
 *
 * References:
 *  https://leetcode.com/problems/frog-position-after-t-seconds/discuss/532505/Java-Straightforward-BFS-Clean-code-O(N)
 */
package com.zea7ot.leetcode.lvl4.lc1377

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import java.util.*
import kotlin.collections.ArrayList

@Suppress(UNUSED)
class SolutionApproach0BFS {
    fun frogPosition(n: Int, edges: Array<IntArray>, t: Int, target: Int): Double {

        val graph = buildGraph(n, edges)

        val prob = DoubleArray(n) { 0.0 }
        prob[0] = 1.0

        val queue = LinkedList<Int>()
        queue.offer(0)

        val visited = BooleanArray(n) { false }
        visited[0] = true

        var time = 0

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val cur = queue.poll()
                var cntNextVertices = 0

                for (next in graph[cur]) {
                    if (!visited[next]) {
                        ++cntNextVertices
                    }
                }

                for (next in graph[cur]) {
                    if (visited[next]) continue
                    visited[next] = true
                    queue.offer(next)
                    prob[next] = prob[cur] / cntNextVertices
                }

                if (cntNextVertices > 0) prob[cur] = 0.0
            }

            if (++time == t) break
        }

        return prob[target - 1]
    }

    private fun buildGraph(n: Int, edges: Array<IntArray>): Array<ArrayList<Int>> {
        val graph = Array(n) { arrayListOf<Int>() }

        for (edge in edges) {
            val (u, v) = edge

            // to turn into 0-indexed
            graph[u - 1].add(v - 1)
            graph[v - 1].add(u - 1)
        }

        return graph
    }
}