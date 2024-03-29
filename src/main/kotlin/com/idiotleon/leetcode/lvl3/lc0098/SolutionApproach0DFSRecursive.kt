package com.idiotleon.leetcode.lvl3.lc0098

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode

/**
 * @author: Leon
 * https://leetcode.com/problems/validate-binary-search-tree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * References:
 *  https://leetcode.com/problems/validate-binary-search-tree/discuss/32112/Learn-one-iterative-inorder-traversal-apply-it-to-multiple-tree-questions-(Java-Solution)
 */
@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    fun isValidBST(root: TreeNode?) = isValidBST(root, null, null)

    private fun isValidBST(node: TreeNode?, lower: Int?, upper: Int?): Boolean {
        if (node == null) return true

        val curVal = node.`val`
        lower?.let { if (it >= curVal) return false }
        upper?.let { if (it <= curVal) return false }

        return isValidBST(node.left, lower, curVal) && isValidBST(node.right, curVal, upper)
    }
}