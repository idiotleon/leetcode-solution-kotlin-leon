/**
 *
 */
package com.zea7ot.leetcode.lvl3.lc1101

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0UnionFind {
    fun earliestAcq(logs: Array<IntArray>, N: Int): Int {
        logs.sortBy { it[0] }

        val uf = UnionFind(N)

        for (log in logs) {
            val timestamp = log[0]
            val idA = log[1]
            val idB = log[2]

            uf.union(idA, idB)

            if (uf.isolated == 1) return timestamp
        }

        return -1
    }

    private class UnionFind(var isolated: Int) {
        private val roots = IntArray(isolated) { idx -> idx }
        private val ranks = IntArray(isolated) { 1 }

        fun union(x: Int, y: Int) {
            val rootX = find(x)
            val rootY = find(y)

            if (rootX == rootY) return

            if (ranks[rootX] > ranks[rootY]) {
                roots[rootY] = rootX
                ++ranks[rootX]
            } else {
                roots[rootX] = rootY
                ++ranks[rootY]
            }

            --isolated
        }

        private fun find(x: Int): Int {
            if (roots[x] != x) {
                roots[x] = find(roots[x])
            }

            return roots[x]
        }
    }
}