package com.an7one.leetcode.lvl4.lc1135

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * https://leetcode.com/problems/connecting-cities-with-minimum-cost/
 *
 * Time Complexity:     O(`nConn` * lg(`nConn`)) + O(E * lg(V)) ~ O(`nConn` * lg(`nConn`)) + O(`nConn` * lg(`N`))
 * Space Complexity:    O(`N`)
 *
 * References:
 *  https://leetcode.com/problems/connecting-cities-with-minimum-cost/discuss/344867/Java-Kruskal's-Minimum-Spanning-Tree-Algorithm-with-Union-Find
 */
@Suppress(UNUSED)
class SolutionApproach0KruskalMST {
    fun minimumCost(N: Int, connections: Array<IntArray>): Int {
        // not used
        // val nConn = connections.size

        connections.sortBy { it[2] }

        val uf = UnionFind(N)

        var cost = 0

        for (conn in connections) {
            val x = conn[0]
            val y = conn[1]

            if (uf.find(x) != uf.find(y)) {
                cost += conn[2]
                uf.union(x, y)
            }
        }

        return if (uf.isolated == 1) cost else -1
    }

    private class UnionFind(var isolated: Int) {
        // 1-indexed, instead of 0-indexed
        private val roots = IntArray(isolated + 1) { idx -> idx }

        // 1-indexed, instead of 0-indexed
        private val ranks = IntArray(isolated + 1) { 1 }

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

            --isolated
        }
    }
}