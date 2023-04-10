/**
 * https://leetcode.com/problems/flower-planting-with-no-adjacent/
 *
 * Time Complexity:     O(N + paths.length)
 * Space Complexity:    O(N)
 *
 * References:
 *  https://leetcode.com/problems/flower-planting-with-no-adjacent/discuss/290858/JavaC%2B%2BPython-Greedily-Paint
 *  https://leetcode.com/problems/flower-planting-with-no-adjacent/discuss/327959/Lee's-Solution-with-Comments
 */
package com.idiotleon.leetcode.lvl3.lc1042

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0Greedy {
    fun gardenNoAdj(nGardens: Int, paths: Array<IntArray>): IntArray {
        val graph = buildGraph(nGardens, paths)

        val ans = IntArray(nGardens)

        for (idx in 0 until nGardens) {
            val colors = IntArray(5) { 0 }
            for (nei in graph[idx]) {
                colors[ans[nei]] = 1
            }

            for (color in 4 downTo 1) {
                if (colors[color] == 0) {
                    ans[idx] = color
                }
            }
        }

        return ans
    }

    private fun buildGraph(nVertices: Int, edges: Array<IntArray>): Array<MutableList<Int>> {
        val graph = Array(nVertices) { mutableListOf<Int>() }

        for (edge in edges) {
            val (u, v) = edge

            graph[u - 1].add(v - 1)
            graph[v - 1].add(u - 1)
        }

        return graph
    }
}