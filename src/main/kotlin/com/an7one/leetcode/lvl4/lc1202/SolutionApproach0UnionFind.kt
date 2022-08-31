package com.an7one.leetcode.lvl4.lc1202

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import java.util.*
import kotlin.collections.HashMap

/**
 * @author: Leon
 * https://leetcode.com/problems/smallest-string-with-swaps/
 *
 * Time Complexity:     O(L) + O(N)
 * Space Complexity:    O(L) + O(N)
 *
 * Reference:
 * https://leetcode.com/problems/smallest-string-with-swaps/discuss/388055/Java-Union-find-%2B-PriorityQueue.-Easy-to-understand.
 */
@Suppress(UNUSED)
class SolutionApproach0UnionFind {
    fun smallestStringWithSwaps(str: String, pairs: List<List<Int>>): String {
        val lenS = str.length
        val uf = UnionFind(lenS)

        for ((x, y) in pairs) {
            uf.union(x, y)
        }

        val map = HashMap<Int, PriorityQueue<Char>>()
        for (idx in str.indices) {
            val root = uf.find(idx)
            map.getOrPut(root) { PriorityQueue() }.add(str[idx])
        }

        val builder = StringBuilder()
        for (idx in str.indices) {
            map[uf.find(idx)]?.let {
                builder.append(it.poll())
            }
        }
        return builder.toString()
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