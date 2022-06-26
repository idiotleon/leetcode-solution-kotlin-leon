package com.an7one.leetcode.lvl3.lc2316

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * this is not yet correct solution
 */
@Suppress(UNUSED)
class SolutionApproach0UnionFind {
    fun countPairs(n: Int, edges: Array<IntArray>): Long {
        val uf = UnionFind(n)
        for (edge in edges) {
            val u = edge[0]
            val v = edge[1]
            uf.unionByRank(u, v)
        }
        return getCount(uf.getRoots())
    }

    private fun getCount(roots: IntArray): Long {
        val rootToFreq: HashMap<Int, Long> = HashMap()
        for ((root, freq) in roots.withIndex()) {
            rootToFreq[root] = rootToFreq.getOrPut(root) { 0 } + freq
        }
        val freqs = rootToFreq.values.toList()
        val lenFs = freqs.size
        var count: Long = 0
        for (lo in 0 until lenFs - 1) {
            for (hi in lo + 1 until lenFs) {
                count += freqs[lo] * freqs[hi]
            }
        }
        return count
    }

    class UnionFind(capacity: Int) {
        private val roots = IntArray(capacity) { idx -> idx }
        private val ranks = IntArray(capacity) { 1 }
        private var isolated = capacity

        fun unionByRank(x: Int, y: Int) {
            val rootX = findIteratively(x)
            val rootY = findRecursively(y)

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

        private fun findRecursively(x: Int): Int {
            if (roots[x] != x) {
                roots[x] = findRecursively(roots[x])
                return roots[x]
            }

            return roots[x]
        }

        private fun findIteratively(x: Int): Int {
            var x = x
            while (x != roots[x]) {
                roots[x] = roots[roots[x]]
                x = roots[x]
            }

            return x
        }

        fun getRoots(): IntArray = roots
    }
}