/**
 * https://leetcode.com/problems/checking-existence-of-edge-length-limited-paths/
 *
 * Time Complexity:     O(`nEdges` * lg(`nEdges`)) + O(`nQueries` * lg(`nQueries`)) + O(`nEdges`) + O(`nQueries`)
 * Space Complexity:    O(`nEdges`) + O(`nQueries`)
 *
 * References:
 *  https://leetcode.com/problems/checking-existence-of-edge-length-limited-paths/discuss/978655/Clean-Java
 */
package com.an7one.leetcode.lvl4.lc1697

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0UnionFind {
    fun distanceLimitedPathsExist(n: Int, edgeList: Array<IntArray>, queries: Array<IntArray>): BooleanArray {
        val nEdges = edgeList.size
        val nQueries = queries.size

        val queryArr = Array(nQueries) { idx ->
            val (from, to, distance) = queries[idx]
            Query(from, to, distance, idx)
        }
        queryArr.sortBy { it.distance }

        edgeList.sortBy { it[2] }

        val uf = UnionFind(n)

        val ans = BooleanArray(nQueries) { false }

        var idxEdge = 0
        for ((queryFrom, queryTo, queryDistance, idxQuery) in queryArr) {
            while (idxEdge < nEdges) {
                val (edgeFrom, edgeTo, edgeWeight) = edgeList[idxEdge]
                if (edgeWeight >= queryDistance) break
                uf.union(edgeFrom, edgeTo)
                ++idxEdge
            }

            ans[idxQuery] = uf.find(queryFrom) == uf.find(queryTo)
        }

        return ans
    }

    private class UnionFind(capacity: Int) {
        private val roots = IntArray(capacity) { idx -> idx }
        private val ranks = IntArray(capacity) { 1 }

        fun union(x: Int, y: Int) {
            val rootX = find(x)
            val rootY = find(y)

            if (rootX == rootY) return

            if (ranks[rootX] > roots[rootY]) {
                roots[rootY] = rootX
                ++ranks[rootX]
            } else {
                roots[rootX] = rootY
                ++ranks[rootY]
            }
        }

        fun find(x: Int): Int {
            if (roots[x] != x) {
                roots[x] = find(roots[x])
            }

            return roots[x]
        }
    }

    private data class Query(val from: Int, val to: Int, val distance: Int, val idx: Int)
}