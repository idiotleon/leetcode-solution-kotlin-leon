package com.idiotleon.leetcode.lvl3.lc0101

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode
import java.util.*

/**
 * @author: Leon
 * https://leetcode.com/problems/symmetric-tree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(W)
 *
 * Reference:
 * https://leetcode.com/problems/symmetric-tree/discuss/33080/Recursive-and-iterative-(DFS-and-BFS)-in-C++.-Easy-to-understand./31882
 * https://leetcode.com/problems/symmetric-tree/discuss/33080/Recursive-and-iterative-(DFS-and-BFS)-in-C%2B%2B.-Easy-to-understand.
 */
@Suppress(UNUSED)
class SolutionApproach0BFS {
    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) return true

        val queue = LinkedList<Pair<TreeNode?, TreeNode?>>().also {
            it.offer(Pair(root.left, root.right))
        }

        while (queue.isNotEmpty()) {
            val size = queue.size

            for (sz in 0 until size) {
                val cur = queue.poll()

                val (left, right) = cur

                if (left == null && right == null) continue
                if (left == null || right == null) return false
                if (left.`val` != right.`val`) return false

                queue.offer(Pair(left.left, right.right))
                queue.offer(Pair(left.right, right.left))
            }
        }

        return true
    }
}