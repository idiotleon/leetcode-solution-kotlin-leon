/**
 * https://leetcode.com/problems/n-ary-tree-level-order-traversal/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(W)
 */
package com.zea7ot.leetcode.lvl2.lc0429

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0BFS {
    fun levelOrder(root: Node?): List<List<Int>> {
        val ans = mutableListOf<List<Int>>()
        if (root == null) return ans

        val queue = LinkedList<Node>().also { it.offer(root) }

        while (queue.isNotEmpty()) {
            val size = queue.size

            val list = mutableListOf<Int>()
            for (sz in 0 until size) {
                val cur = queue.poll()
                list.add(cur.`val`)

                for (node in cur.children) {
                    if (node == null) continue
                    queue.offer(node)
                }
            }

            ans.add(list)
        }

        return ans
    }
}