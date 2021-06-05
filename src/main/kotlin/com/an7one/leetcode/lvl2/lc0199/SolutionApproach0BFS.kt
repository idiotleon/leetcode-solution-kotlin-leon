/**
 * @author: Leon
 * https://leetcode.com/problems/binary-tree-right-side-view/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(W)
 */
package com.an7one.leetcode.lvl2.lc0199

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import com.an7one.leetcode.util.dataStructure.tree.TreeNode
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0BFS {
    fun rightSideView(root: TreeNode?): List<Int> {
        val ans = mutableListOf<Int>()
        // sanity check
        if (root == null)
            return ans

        val queue = LinkedList<TreeNode>().also {
            it.offer(root)
        }

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val cur = queue.poll()

                val value = cur.`val`

                if (sz == size - 1)
                    ans.add(value)

                cur.left?.let { queue.offer(it) }
                cur.right?.let { queue.offer(it) }
            }
        }

        return ans
    }
}