package com.idiotleon.leetcode.lvl2.lc0111

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode
import kotlin.collections.ArrayDeque

/**
 * @author: Len
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(W)
 *
 * References:
 *  https://leetcode.com/problems/minimum-depth-of-binary-tree/discuss/36045/My-4-Line-java-solution/140333
 *  https://leetcode.com/problems/minimum-depth-of-binary-tree/discuss/36045/My-4-Line-java-solution/242269
 */
@Suppress(UNUSED)
class SolutionApproach0BFS {
    fun minDepth(root: TreeNode?): Int {
        if (root == null) return 0

        val queue = ArrayDeque<TreeNode>().also { it.addLast(root) }

        var height = 1

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val cur = queue.removeFirst()

                if (cur.left == null && cur.right == null)
                    return height

                cur.left?.let { queue.addLast(it) }
                cur.right?.let { queue.addLast(it) }
            }

            ++height
        }

        return -1
    }
}