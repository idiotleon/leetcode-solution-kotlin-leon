package com.zea7ot.leetcode.lvl3.lc0257

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import com.zea7ot.leetcode.util.dataStructure.tree.TreeNode

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