package com.an7one.summary.byDataStructure.unionFind.byRank

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 *
 * Time Complexity:     O(amortized(1))
 * Space Complexity:    O(`capacity`)
 *
 * to union by rank
 * to find roots with path compression
 *
 * References:
 *  https://youtu.be/gBmwoxsL8lY?t=555
 */
@Suppress(UNUSED)
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

    @Suppress(UNUSED)
    fun findRecursively(x: Int): Int {
        if (roots[x] != x) {
            roots[x] = findRecursively(roots[x])
            return roots[x]
        }

        return roots[x]
    }

    @Suppress(UNUSED)
    fun findIteratively(x: Int): Int {
        var x = x
        while (x != roots[x]) {
            roots[x] = roots[roots[x]]
            x = roots[x]
        }

        return x
    }
}