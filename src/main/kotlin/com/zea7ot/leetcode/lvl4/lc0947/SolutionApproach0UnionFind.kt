/**
 *
 */
package com.zea7ot.leetcode.lvl4.lc0947

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0UnionFind {
    fun removeStones(stones: Array<IntArray>): Int {
        val totalStones = stones.size

        val uf = UnionFind(totalStones + 1)

        for (lo in stones.indices) {
            for (hi in lo + 1 until totalStones) {
                val stone1 = stones[lo]
                val stone2 = stones[hi]

                if (stone1[0] == stone2[0] || stone1[1] == stone2[1]) {
                    uf.union(lo, hi)
                }
            }
        }

        return totalStones - uf.getCount()
    }

    private class UnionFind(private var isolated: Int) {
        private val roots = IntArray(isolated) { idx -> idx }
        private val ranks = IntArray(isolated) { 1 }

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

            --isolated
        }

        fun find(x: Int): Int {
            if (x != roots[x]) {
                roots[x] = find(roots[x])
            }

            return roots[x]
        }

        fun getCount(): Int {
            var count = 0
            for (idx in roots.indices) {
                if (idx == roots[idx]) {
                    ++count
                }
            }

            return count
        }
    }
}