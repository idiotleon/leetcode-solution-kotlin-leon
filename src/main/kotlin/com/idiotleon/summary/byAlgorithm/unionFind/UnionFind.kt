/**
 * @author: Leon
 *
 * References:
 *  https://www.cs.princeton.edu/~rs/AlgsDS07/01UnionFind.pdf
 *  https://algs4.cs.princeton.edu/15uf/
 */
package com.idiotleon.summary.byAlgorithm.unionFind

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class UnionFind(size: Int) {
    private val roots = IntArray(size) { idx -> idx }
    private val ranks = IntArray(size) { 1 }
    private var curSize = size

    fun union(x: Int, y: Int) {
        val rootX = findRecusively(x)
        val rootY = findIteratively(y)

        if (rootX == rootY) return

        if (ranks[rootX] > ranks[rootY]) {
            roots[rootY] = rootX
            ++ranks[rootX]
        } else {
            roots[rootX] = rootY
            ++ranks[rootY]
        }

        --curSize
    }

    fun findRecusively(x: Int): Int {
        if (x != roots[x]) {
            roots[x] = findRecusively(roots[x])
        }

        return roots[x]
    }

    fun findIteratively(i: Int): Int {
        var x = i
        while (x != roots[x]) {
            roots[x] = roots[roots[x]]
            x = roots[x]
        }

        return x
    }
}