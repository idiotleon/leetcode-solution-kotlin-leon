package com.idiotleon.leetcode.lvl1.lc2236

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode

/**
 * @author: Leon
 * https://leetcode.com/problems/root-equals-sum-of-children/
 *
 * Time Complexity:     O(1)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution0BrutalForce {
    fun checkTree(root: TreeNode?): Boolean {
        if (root?.left == null || root.right == null) {
            return false
        }

        return root.`val` == root.left!!.`val` + root.right!!.`val`
    }
}