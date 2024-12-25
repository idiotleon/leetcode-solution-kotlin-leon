package com.idiotleon.leetcode.lvl2.lc0515

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode

/**
 * @author: Leon
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 *
 * Reference:
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/solutions/98971/9ms-java-dfs-solution/
 */
@Suppress(UNUSED)
class Solution0PreorderRecursive {
    fun largestValues(root: TreeNode?): List<Int> {
        if (root == null) {
            return emptyList()
        }
        val ans = mutableListOf<Int>()
        preorder(0, root, ans)
        return ans
    }

    private fun preorder(level: Int, node: TreeNode?, res: MutableList<Int>) {
        if (node == null) {
            return
        }

        val value = node.`val`
        if (level == res.size) {
            res.add(value)
        } else {
            res[level] = maxOf(res[level], value)
        }
        preorder(level + 1, node.left, res)
        preorder(level + 1, node.right, res)
    }
}