/**
 * @author: Leon
 *
 * Time Complexity:     O(amortized(1))
 * Space Complexity:    O(`capacity`)
 *
 * to union by size
 * to find roots with path compression
 *
 * References:
 *  https://youtu.be/gBmwoxsL8lY?t=555
 */
package com.an7one.summary.byDataStructure.unionFind.bySize

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class UnionFind(capacity: Int) {
    private val roots = IntArray(capacity) { idx -> idx }
    private val sizes = IntArray(capacity) { 1 }
    private var isolated = capacity

    fun unionByRank(x: Int, y: Int) {
        val rootX = findRecursive(x)
        val rootY = findIterative(y)

        if (rootX == rootY) return

        if (sizes[rootX] > sizes[rootY]) {
            roots[rootY] = rootX
            sizes[rootX] += sizes[rootY]
        } else {
            roots[rootX] = rootY
            sizes[rootY] += sizes[rootX]
        }

        --isolated
    }

    fun findRecursive(x: Int): Int {
        if (roots[x] != x) {
            roots[x] = findRecursive(roots[x])
            return roots[x]
        }

        return roots[x]
    }

    fun findIterative(x: Int): Int {
        while (x != roots[x]) {
            roots[x] = roots[roots[x]]
        }

        return roots[x]
    }
}