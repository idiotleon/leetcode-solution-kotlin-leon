package com.idiotleon.leetcode.lvl2.lc0226

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode
import kotlin.collections.ArrayDeque

/**
 * @author: Leon
 * https://leetcode.com/problems/invert-binary-tree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * References:
 *  https://leetcode.com/problems/invert-binary-tree/discuss/62707/Straightforward-DFS-recursive-iterative-BFS-solutions
 */
@Suppress(UNUSED)
class SolutionApproach0PreorderIterative {
    @OptIn(ExperimentalStdlibApi::class)
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) return null

        val stack = ArrayDeque<TreeNode>().also { it.addLast(root) }

        while (stack.isNotEmpty()) {
            val top = stack.removeLast()
            val left = top.left
            top.left = top.right
            top.right = left

            top.left?.let { stack.addLast(it) }
            top.right?.let { stack.addLast(it) }
        }

        return root
    }
}