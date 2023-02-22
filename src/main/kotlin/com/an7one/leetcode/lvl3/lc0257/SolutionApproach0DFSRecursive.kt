package com.an7one.leetcode.lvl3.lc0257

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import com.an7one.leetcode.util.dataStructure.tree.TreeNode

/**
 * @author: Leon
 * https://leetcode.com/problems/binary-tree-paths/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    private companion object {
        private const val ARROW = "->"
    }

    fun binaryTreePaths(root: TreeNode?): List<String> {
        val path = ""
        val paths = mutableListOf<String>()

        dfs(root, path, paths)

        return paths
    }

    private fun dfs(node: TreeNode?, path: String, paths: MutableList<String>) {
        if (node == null) return

        val value = node.`val`
        val newPath = path + value.toString()

        if (node.left == null && node.right == null) {
            paths.add(newPath)
            return
        }


        node.left?.let {
            dfs(it, newPath + ARROW, paths)
        }

        node.right?.let {
            dfs(it, newPath + ARROW, paths)
        }
    }
}