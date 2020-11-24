/**
 * https://leetcode.com/problems/invert-binary-tree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * References:
 *  https://leetcode.com/problems/invert-binary-tree/discuss/62707/Straightforward-DFS-recursive-iterative-BFS-solutions
 */
package com.zea7ot.leetcode.lvl2.lc0226

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.utils.dataStructure.tree.TreeNode
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0DFSIterative {
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) return null

        val stack = LinkedList<TreeNode>().also { it.push(root) }

        while (stack.isNotEmpty()) {
            val top = stack.pop()
            val left = top.left
            top.left = top.right
            top.right = left

            top.left?.let { stack.push(it) }
            top.right?.let { stack.push(it) }
        }

        return root
    }
}