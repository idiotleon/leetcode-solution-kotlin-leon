/**
 * @author: Leon
 *
 * Time Complexity:     O(V ^ 2) + O(E) ~ O(V ^ 2)
 * Space Complexity:    O()
 *
 * suitable for dense graphs
 *
 * steps:
 *  1. distances[0] = 0, distances[v] = +∞
 *  2. for v in [1, n]:
 *      t: 不在s中的距离最近的点
 *      s
 *      用t更新其它点的距离
 *
 * References:
 *  Paid Course: https://www.acwing.com/video/24/
 *  https://blog.csdn.net/qq_35356840/article/details/106516347
 *  https://leetcode-cn.com/problems/network-delay-time/solution/dan-yuan-zui-duan-lu-po-su-de-dijkstra-dui-you-hua/
 *  https://leetcode-cn.com/problems/network-delay-time/solution/java-ban-dijkstra-spfa-floydxiang-xi-ti-jie-by-jer/
 */
package com.an7one.summary.byDataStructure.graph.shortestPath.withDiffEdgeWeight.singleSource.positiveEdgeWeightsOnly.withoutHeap

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class DijkstraSPF {
    private companion object {
        private const val DATA_RANGE = 1e6.toInt() + 1
    }

    fun dijkstraSPF(nVertices: Int, graph: Array<IntArray>): Int {
        val distances = IntArray(nVertices) { DATA_RANGE }.also { it[1] = 0 }
        val shortestPathFound = BooleanArray(nVertices) { false }

        for (i in 0 until nVertices) {
            var t = -1
            for (j in 1..nVertices) {
                if (!shortestPathFound[j] && (t == -1 || distances[t] > distances[j])) {
                    t = j
                }
            }

            shortestPathFound[t] = true

            for (j in 1..nVertices) {
                distances[j] = minOf(distances[j], distances[t] + graph[t][j])
            }
        }

        return distances[nVertices].let {
            if (it == DATA_RANGE) -1
            else it
        }
    }
}