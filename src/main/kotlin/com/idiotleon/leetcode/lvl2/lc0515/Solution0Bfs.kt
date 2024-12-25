package com.idiotleon.leetcode.lvl2.lc0515

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode

/**
 * @author: Leon
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(W)
 */
@Suppress(UNUSED)
class Solution0Bfs {
    fun largestValues(root: TreeNode?): List<Int> {
        if (root == null) {
            return emptyList()
        }

        val queue = ArrayDeque<TreeNode>().also {
            it.addLast(root)
        }

        val ans = mutableListOf<Int>()
        while (queue.isNotEmpty()) {
            val size = queue.size
            var max = Int.MIN_VALUE
            for (sz in 0 until size) {
                val first = queue.removeFirst()
                max = maxOf(max, first.`val`)

                first.left?.let { queue.addLast(it) }
                first.right?.let { queue.addLast(it) }
            }
            ans.add(max)
        }

        return ans
    }
}