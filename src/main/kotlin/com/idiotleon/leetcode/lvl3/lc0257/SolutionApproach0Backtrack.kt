package com.idiotleon.leetcode.lvl3.lc0257

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode

/**
 * @author: Leon
 * https://leetcode.com/problems/binary-tree-paths/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
@Suppress(UNUSED)
class SolutionApproach0Backtrack {
    private companion object {
        private const val ARROW = "->"
    }

    fun binaryTreePaths(root: TreeNode?): List<String> {
        val paths = mutableListOf<String>()
        val builder = StringBuilder()

        dfs(root, builder, paths)

        return paths
    }

    private fun dfs(
        node: TreeNode?,
        builder: StringBuilder,
        paths: MutableList<String>
    ) {
        if (node == null) return

        val value = node.`val`
        builder.append(value)

        if (node.left == null && node.right == null) {
            paths.add(builder.toString())
            return
        }

        val len = builder.length
        builder.append(ARROW)
        node.left?.let {
            dfs(it, builder, paths)
        }
        builder.setLength(len)

        builder.append(ARROW)
        node.right?.let {
            dfs(it, builder, paths)
        }
        builder.setLength(len)
    }
}