package com.idiotleon.leetcode.lvl4.lc1135

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

/**
 * @author: Leon
 * https://leetcode.com/problems/connecting-cities-with-minimum-cost/
 *
 * Time Complexity:     O(`nConn` * lg(`nConn`)) + O((E + V) * lg(V)) ~ O(`nConn` * lg(`nConn`)) + O((`O(`nConn` * lg(`nConn` + `N`)) * lg(`N`))
 * Space Complexity:    O(`N`)
 *
 * References:
 *  https://leetcode.com/problems/connecting-cities-with-minimum-cost/discuss/344867/Java-Kruskal's-Minimum-Spanning-Tree-Algorithm-with-Union-Find/669058
 *  https://leetcode.com/problems/connecting-cities-with-minimum-cost/discuss/344867/Java-Kruskal's-Minimum-Spanning-Tree-Algorithm-with-Union-Find
 */
@Suppress(UNUSED)
class SolutionApproach1PrimMST {
    fun minimumCost(N: Int, connections: Array<IntArray>): Int {
        // not used
        // val nConn = connections.size

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

    private class UnionFind(nCities: Int) {
        // 1-indexed, instead of 0-indexed
        private val roots = IntArray(nCities + 1) { idx -> idx }

        // 1-indexed, instead of 0-indexed
        private val ranks = IntArray(nCities + 1) { 1 }

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