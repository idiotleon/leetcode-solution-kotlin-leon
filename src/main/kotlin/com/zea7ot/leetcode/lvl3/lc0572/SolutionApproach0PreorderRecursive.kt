/**
 * https://leetcode.com/problems/subtree-of-another-tree/
 *
 * Time Complexity:     O(N_S * N_T)
 * Space Complexity:    O(H_S + H_T)
 *
 * References:
 *  https://leetcode.com/problems/subtree-of-another-tree/discuss/102724/Java-Solution-tree-traversal
 */
package com.zea7ot.leetcode.lvl3.lc0572

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import com.zea7ot.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0PreorderRecursive {
    fun isSubtree(s: TreeNode?, t: TreeNode?) = preorder(s, t)

    private fun preorder(s: TreeNode?, t: TreeNode?): Boolean {
        if (s == null) return false

        if (isSameTree(s, t)) return true
        return preorder(s.left, t) || preorder(s.right, t)
    }

    private fun isSameTree(s: TreeNode?, t: TreeNode?): Boolean {
        if (s == null && t == null) return true
        if (s == null || t == null) return false

        if (s.`val` != t.`val`) return false

        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right)
    }
}