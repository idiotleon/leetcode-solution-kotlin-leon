/**
 * @author: Leon
 * https://leetcode.com/problems/graph-connectivity-with-threshold/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 */
package com.zea7ot.leetcode.lvl4.lc1627

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0UnionFind {
    fun areConnected(n: Int, threshold: Int, queries: Array<IntArray>): List<Boolean> {
        val uf = UnionFind(n + 1)
        for (i in threshold + 1..n) {
            for (j in i..n step i) {
                uf.union(i, j)
            }
        }

        val ans = ArrayList<Boolean>()
        for (query in queries) {
            ans.add(uf.find(query[0]) == uf.find(query[1]))
        }

        return ans
    }

    private class UnionFind(n: Int) {
        private val roots = IntArray(n) { idx -> idx }
        private val ranks = IntArray(n) { 1 }

        fun find(x: Int): Int {
            if (roots[x] != x) {
                roots[x] = find(roots[x])
            }

            return roots[x]
        }

        fun union(x: Int, y: Int) {
            val rootX = find(x)
            val rootY = find(y)

            if (ranks[rootX] > ranks[rootY]) {
                roots[rootY] = rootX
                ++ranks[rootX]
            } else {
                roots[rootX] = rootY
                ++ranks[rootY]
            }
        }
    }
}