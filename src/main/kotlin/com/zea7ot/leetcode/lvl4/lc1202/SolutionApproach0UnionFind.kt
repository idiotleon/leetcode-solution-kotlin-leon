/**
 * @author: Leon
 * https://leetcode.com/problems/smallest-string-with-swaps/
 *
 * Time Complexity:     O(L) + O(N)
 * Space Complexity:    O(L) + O(N)
 *
 * References:
 *  https://leetcode.com/problems/smallest-string-with-swaps/discuss/388055/Java-Union-find-%2B-PriorityQueue.-Easy-to-understand.
 */
package com.zea7ot.leetcode.lvl4.lc1202

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED
import java.util.*
import kotlin.collections.HashMap

@Suppress(UNUSED)
class SolutionApproach0UnionFind {
    fun smallestStringWithSwaps(s: String, pairs: List<List<Int>>): String {
        val lenS = s.length
        val uf = UnionFind(lenS)

        for (pair in pairs) {
            uf.union(pair[0], pair[1])
        }

        val map = HashMap<Int, PriorityQueue<Char>>()
        for (idx in s.indices) {
            val root = uf.find(idx)
            map.getOrPut(root) { PriorityQueue() }.add(s[idx])
        }

        val builder = StringBuilder()
        for (idx in s.indices) {
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