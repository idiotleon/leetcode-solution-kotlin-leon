/**
 * https://leetcode.com/problems/connecting-cities-with-minimum-cost/
 *
 * Time Complexity:     O(`totalConn` * lg(`totalConn`)) + O((E + V) * lg(V)) ~ O(`totalConn` * lg(`totalConn`)) + O((`O(`totalConn` * lg(`totalConn` + `N`)) * lg(`N`))
 * Space Complexity:    O(`N`)
 *
 * References:
 *  https://leetcode.com/problems/connecting-cities-with-minimum-cost/discuss/344867/Java-Kruskal's-Minimum-Spanning-Tree-Algorithm-with-Union-Find/669058
 *  https://leetcode.com/problems/connecting-cities-with-minimum-cost/discuss/344867/Java-Kruskal's-Minimum-Spanning-Tree-Algorithm-with-Union-Find
 */
package com.zea7ot.leetcode.lvl4.lc1135

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach1PrimMST {
    fun minimumCost(N: Int, connections: Array<IntArray>): Int {
        // not used
        // val totalConn = connections.size

        val minHeap = PriorityQueue<IntArray>(compareBy { it[2] })
        for (conn in connections) {
            minHeap.offer(conn)
        }

        val uf = UnionFind(N)

        var cost = 0
        var edge = 0

        while (minHeap.isNotEmpty()) {
            val cur = minHeap.poll()
            val x = cur[0]
            val y = cur[1]
            val rootX = uf.find(x)
            val rootY = uf.find(y)

            if (rootX != rootY) {
                cost += cur[2]
                uf.union(x, y)
                if (++edge == N - 1) return cost
            }
        }

        return -1
    }

    private class UnionFind(totalCities: Int) {
        // 1-indexed, instead of 0-indexed
        private val roots = IntArray(totalCities + 1) { idx -> idx }

        // 1-indexed, instead of 0-indexed
        private val ranks = IntArray(totalCities + 1) { 1 }

        fun find(x: Int): Int {
            if (roots[x] != x) {
                roots[x] = find(roots[x])
            }

            return roots[x]
        }

        fun union(x: Int, y: Int) {
            val rootX = find(x)
            val rootY = find(y)

            if (ranks[rootX] < ranks[rootY]) {
                roots[rootX] = rootY
                ++ranks[rootY]
            } else {
                roots[rootY] = rootX
                ++ranks[rootX]
            }
        }
    }
}