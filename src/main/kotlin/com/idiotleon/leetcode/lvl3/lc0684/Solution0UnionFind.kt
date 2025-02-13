package com.idiotleon.leetcode.lvl3.lc0684

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/redundant-connection/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * Reference:
 * https://leetcode.com/problems/redundant-connection/discuss/123819/Union-Find-with-Explanations-(Java-Python)/178669
 */
@Suppress(UNUSED)
class Solution0UnionFind {
    private companion object {
        private const val RANGE_DATA = 1000 * 2 + 1
    }

    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val roots = IntArray(RANGE_DATA) { idx -> idx }

        for (edge in edges) {
            val (u, v) = edge
            val root1 = find(u, roots)
            val root2 = find(v, roots)

            if (root1 == root2) {
                return edge
            } else {
                roots[root2] = root1
            }
        }

        return intArrayOf(0, 0)
    }

    private fun find(x: Int, roots: IntArray): Int {
        if (x != roots[x]) {
            roots[x] = find(roots[x], roots)
        }

        return roots[x]
    }
}