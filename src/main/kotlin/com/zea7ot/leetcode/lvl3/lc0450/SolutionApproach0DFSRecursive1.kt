/**
 * https://leetcode.com/problems/delete-node-in-a-bst/
 *
 * Time Complexity:     O(H)
 * Space Complexity:    O(H)
 *
 * References:
 *  https://leetcode.com/problems/delete-node-in-a-bst/discuss/93296/Recursive-Easy-to-Understand-Java-Solution/97795
 *  https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247488128&idx=2&sn=b8fb3fd2917f9ac86127054741cd5877&chksm=9bd7ec88aca0659ee0185b657663169169493e9df2063fa4d28b38a0b4d0dd698d0301937898&scene=21#wechat_redirect
 */
package com.zea7ot.leetcode.lvl3.lc0450

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive1 {
    fun deleteNode(root: TreeNode?, key: Int) = delete(root, key)

    private fun delete(node: TreeNode?, toBeDeleted: Int): TreeNode? {
        if (node == null) return null

        val value = node.`val`

        when {
            value > toBeDeleted -> node.left = delete(node.left, toBeDeleted)
            value < toBeDeleted -> node.right = delete(node.right, toBeDeleted)
            else -> {
                if (node.left == null) return node.right
                if (node.right == null) return node.left

                var rightSmallest = node.right
                while (rightSmallest!!.left != null) {
                    rightSmallest = rightSmallest.left
                }
                rightSmallest.left = node.left

                return node.right
            }
        }

        return node
    }
}