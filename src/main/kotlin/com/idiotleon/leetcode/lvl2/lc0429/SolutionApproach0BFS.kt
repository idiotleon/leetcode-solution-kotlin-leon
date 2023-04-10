package com.idiotleon.leetcode.lvl2.lc0429

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/n-ary-tree-level-order-traversal/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(W)
 */
@Suppress(UNUSED)
class SolutionApproach0BFS {
    fun levelOrder(root: Node?): List<List<Int>> {
        val ans = mutableListOf<List<Int>>()
        if (root == null) return ans

        val queue = ArrayDeque<Node>().also { it.addLast(root) }

        while (queue.isNotEmpty()) {
            val size = queue.size

            val list = mutableListOf<Int>()
            for (sz in 0 until size) {
                val cur = queue.removeFirst()
                list.add(cur.`val`)

                for (node in cur.children) {
                    if (node == null) continue
                    queue.addLast(node)
                }
            }

            ans.add(list)
        }

        return ans
    }
}