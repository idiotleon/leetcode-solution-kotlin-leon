/**
 * @author: Leon
 * https://leetcode.com/problems/path-sum-ii/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.zea7ot.leetcode.lvl3.lc0113

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import com.zea7ot.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0Backtrack {
    fun pathSum(root: TreeNode?, sum: Int): List<List<Int>> {
        val path = mutableListOf<Int>()
        val paths = mutableListOf<List<Int>>()

        backtrack(root, sum, path, paths)

        return paths
    }

    private fun backtrack(
        node: TreeNode?,
        target: Int,
        path: MutableList<Int>,
        paths: MutableList<List<Int>>
    ) {
        if (node == null) return

        val value = node.`val`
        path.add(value)

        if (target == value && node.left == null && node.right == null) {
            paths.add(path.toList())
        } else {
            backtrack(node.left, target - value, path, paths)
            backtrack(node.right, target - value, path, paths)
        }

        path.removeAt(path.size - 1)
    }
}