/**
 * @author: Leon
 *
 * Pseudocode:
 *  distances[i] -> +∞
 *  for(i = 0; i < n; ++i){
 *      t <- 找到集合外距离最近的点
 *      用t更新其它点到集合的距离
 *      st[t] = true
 *  }
 *
 * References:
 *  Paid Course: https://www.acwing.com/video/25/
 */
package com.an7one.summary.byDataStructure.graph.minimumSpanningTree

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class PrimMSTPlain {
    private companion object {
        private const val DATA_RANGE = 1e6.toInt()
    }

    fun primMST(graph: Array<IntArray>, nVertices: Int): Int {
        val distances = IntArray(nVertices) { DATA_RANGE }
        val visited = BooleanArray(nVertices) { false }

        var minSpan = 0
        for (i in 0 until nVertices) {
            var t = -1
            for (j in 1..nVertices) {
                if (!visited[j] && (t == -1 || distances[t] > distances[j])) {
                    t = j
                }
            }

            // isolated/dislocated
            if (i > 0 && distances[t] == DATA_RANGE) return DATA_RANGE
            if (i > 0) minSpan += distances[t]

            // to update the rest of vertices
            for (j in 1..nVertices) {
                distances[j] = minOf(distances[j], graph[t][j])

                // in comparison, for DijkstraSFP, the addition means the distance from the vertices to the source vertex
                // distances[j] = minOf(distances[j], distances[t] + graph[t][j])
            }

            visited[t] = true
        }

        return minSpan
    }
}