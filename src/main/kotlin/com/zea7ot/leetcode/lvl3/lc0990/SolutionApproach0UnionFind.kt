/**
 * @author: Leon
 * https://leetcode.com/problems/satisfiability-of-equality-equations/
 *
 * Time Complexity:     O(`totalEqs`)
 * Space Complexity:    O(26) ~ O(1)
 */
package com.zea7ot.leetcode.lvl3.lc0990

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED

@Suppress(UNUSED)
class SolutionApproach0UnionFind {
    private companion object {
        private const val RANGE = 26

        private const val EQUAL = '='
        private const val NOT_EQUAL = '!'
    }

    fun equationsPossible(equations: Array<String>): Boolean {
        // not used
        // val totalEqs = equations.size

        val uf = UnionFind(RANGE)

        for (eq in equations) {
            if (eq[1] == EQUAL) {
                val first = eq.first() - 'a'
                val last = eq.last() - 'a'
                uf.union(first, last)
            }
        }

        for (eq in equations) {
            if (eq[1] == NOT_EQUAL) {
                val first = eq.first() - 'a'
                val last = eq.last() - 'a'

                if (uf.find(first) == uf.find(last)) return false
            }
        }

        return true
    }

    private class UnionFind(isolated: Int) {
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
        }

        fun find(x: Int): Int {
            if (roots[x] != x) {
                roots[x] = find(roots[x])
            }

            return roots[x]
        }
    }
}