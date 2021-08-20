/**
 * @author: Leon
 * https://leetcode.com/problems/find-if-path-exists-in-graph/
 *
 * Time Complexity:     O(V + E) ~ O(`n` + `nEdges`)
 * Space Complexity:    O(V + E) ~ O(`n` + `nEdges`)
 */
package com.an7one.leetcode.lvl2.lc1971

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0UnionFind {
    fun validPath(n: Int, edges: Array<IntArray>, start: Int, end: Int): Boolean {
        val roots = IntArray(n) { idx -> idx }
        val ranks = IntArray(n) { 1 }

        for ((u, v) in edges) {
            union(u, v, roots, ranks)
        }

        return find(start, roots) == find(end, roots)
    }

    private fun union(x: Int, y: Int, roots: IntArray, ranks: IntArray) {
        val rootX = find(x, roots)
        val rootY = find(y, roots)

        if (rootX == rootY)
            return

        if (ranks[rootX] > ranks[rootY]) {
            roots[rootY] = rootX
            ++ranks[rootX]
        } else {
            roots[rootX] = rootY
            ++ranks[rootY]
        }
    }

    private fun find(x: Int, roots: IntArray): Int {
        var x = x
        while (x != roots[x]) {
            roots[x] = roots[roots[x]]
            x = roots[x]
        }

        return x
    }
}