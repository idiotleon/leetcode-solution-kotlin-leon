/**
 * https://leetcode.com/problems/invert-binary-tree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * References:
 *  https://leetcode.com/problems/invert-binary-tree/discuss/62707/Straightforward-DFS-recursive-iterative-BFS-solutions
 */
package com.an7one.leetcode.lvl2.lc0226

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import com.an7one.leetcode.util.dataStructure.tree.TreeNode
import java.util.*
import kotlin.collections.ArrayDeque

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