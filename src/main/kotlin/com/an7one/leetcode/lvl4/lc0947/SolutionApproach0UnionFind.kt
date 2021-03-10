/**
 * https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
 *
 * Time Complexity:     O(`nStones` ^ 2)
 * Space Complexity:    O(`nStones`)
 *
 * References:
 *  https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/discuss/197668/Count-the-Number-of-Islands-O(N)
 */
package com.an7one.leetcode.lvl4.lc0947

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0UnionFind {
    fun removeStones(stones: Array<IntArray>): Int {
        val nStones = stones.size

        val uf = UnionFind(nStones)

        for (lo in stones.indices) {
            for (hi in lo + 1 until nStones) {
                val (row1, col1) = stones[lo]
                val (row2, col2) = stones[hi]

                if (row1 == row2 || col1 == col2) {
                    uf.union(lo, hi)
                }
            }
        }

        return nStones - uf.getCount()
    }


    private class UnionFind(capacity: Int) {
        private val roots = IntArray(capacity) { idx -> idx }
        private val ranks = IntArray(capacity) { 1 }

        fun union(x: Int, y: Int) {
            val rootX = find(x)
            val rootY = find(y)

            if (rootX == rootY) return

            if (roots[rootX] > roots[rootY]) {
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