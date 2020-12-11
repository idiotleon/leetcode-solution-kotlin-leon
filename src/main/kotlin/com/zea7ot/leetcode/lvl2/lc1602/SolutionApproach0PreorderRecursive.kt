/**
 * https://leetcode.com/problems/find-nearest-right-node-in-binary-tree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * References:
 *  https://leetcode.com/problems/find-nearest-right-node-in-binary-tree/discuss/872996/Java-O(n)-Preorder
 */
package com.zea7ot.leetcode.lvl2.lc1602

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0PreorderRecursive {
    private var res: TreeNode? = null
    private var targetDepth: Int = -1

    fun findNearestRightNode(root: TreeNode?, u: TreeNode?): TreeNode? {
        preorder(root, u, 0)
        return res
    }

    private fun preorder(node: TreeNode?, target: TreeNode?, curDepth: Int) {
        if (node == null) return
        if (node == target) {
            targetDepth = curDepth
            return
        }

        if (targetDepth == curDepth && res == null) {
            res = node
            return
        }

        preorder(node.left, target, curDepth + 1)
        preorder(node.right, target, curDepth + 1)
    }
}