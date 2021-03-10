/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(W)
 *
 * References:
 *  https://leetcode.com/problems/minimum-depth-of-binary-tree/discuss/36045/My-4-Line-java-solution/140333
 *  https://leetcode.com/problems/minimum-depth-of-binary-tree/discuss/36045/My-4-Line-java-solution/242269
 */
package com.an7one.leetcode.lvl2.lc0111

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import com.an7one.leetcode.util.dataStructure.tree.TreeNode
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0BFS {
    fun minDepth(root: TreeNode?): Int {
        if (root == null) return 0

        val queue = LinkedList<TreeNode>().also { it.offer(root) }

        var height = 1

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val cur = queue.poll()

                if (cur.left == null && cur.right == null)
                    return height

                cur.left?.let { queue.offer(it) }
                cur.right?.let { queue.offer(it) }
            }

            ++height
        }

        return -1
    }
}