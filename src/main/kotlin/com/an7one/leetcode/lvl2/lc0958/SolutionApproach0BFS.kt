/**
 * https://leetcode.com/problems/check-completeness-of-a-binary-tree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(W)
 *
 * Reference:
 *  https://leetcode.com/problems/check-completeness-of-a-binary-tree/discuss/205768/Java-easy-Level-Order-Traversal-one-while-loop
 */
package com.an7one.leetcode.lvl2.lc0958

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import com.an7one.leetcode.util.dataStructure.tree.TreeNode
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0BFS {
    fun isCompleteTree(root: TreeNode?): Boolean {
        val queue = LinkedList<TreeNode?>().also {
            it.offer(root)
        }

        var isEnd = false

        while (queue.isNotEmpty()) {
            val cur = queue.poll()

            if (cur == null)
                isEnd = true
            else {
                if (isEnd)
                    return false

                queue.offer(cur!!.left)
                queue.offer(cur!!.right)
            }
        }

        return true
    }
}