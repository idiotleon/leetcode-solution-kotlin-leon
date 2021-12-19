/**
 * https://leetcode.com/problems/binary-tree-paths/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.an7one.leetcode.lvl2.lc0257

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import com.an7one.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0BacktrackRecursive {
    fun binaryTreePaths(root: TreeNode?): List<String> {
        val ans = mutableListOf<String>()
        val builder = StringBuilder()
        backtrack(root, builder, ans)
        return ans
    }

    private fun backtrack(node: TreeNode?, builder: StringBuilder, res: MutableList<String>) {
        if (node == null) return

        builder.append(node.`val`.toString())

        if (node.left == null && node.right == null) {
            res.add(builder.toString())
            return
        }

        val len = builder.length

        builder.append("->")
        backtrack(node.left, builder, res)
        builder.setLength(len)

        builder.append("->")
        backtrack(node.right, builder, res)
        builder.setLength(len)
    }
}