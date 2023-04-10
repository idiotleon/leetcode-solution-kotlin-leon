/**
 * https://leetcode.com/problems/correct-a-binary-tree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 *
 * References:
 *  https://leetcode.com/problems/correct-a-binary-tree/discuss/940769/Java-HashSet.-One-Pass.-Short.
 */
package com.idiotleon.leetcode.lvl3.lc1660

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    fun correctBinaryTree(root: TreeNode?): TreeNode? {
        val seen = HashSet<Int>()

        return dfs(root, seen)
    }

    private fun dfs(node: TreeNode?, seen: HashSet<Int>): TreeNode? {
        if (node == null) return null
        node.right?.let {
            if (seen.contains(it.`val`)) {
                return null
            }
        }

        seen.add(node.`val`)
        node.right = dfs(node.right, seen)
        node.left = dfs(node.left, seen)
        return node
    }
}