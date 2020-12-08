/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * References:
 *  https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247487126&idx=1&sn=4de13e66397bc35970963c5a1330ce18&chksm=9bd7f09eaca0798853c41fba05ad5fa958b31054eba18b69c785ae92f4bd8e4cc7a2179d7838&scene=21#wechat_redirect
 */
package com.zea7ot.leetcode.lvl2.lc0114

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.utils.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0PostorderRecursive {
    fun flatten(root: TreeNode?) = postorder(root)

    private fun postorder(node: TreeNode?) {
        if (node == null) return

        postorder(node.left)
        postorder(node.right)

        val left = node.left
        val right = node.right

        node.left = null
        node.right = left

        var cur = node
        while (cur?.right != null) {
            cur = cur.right
        }
        cur?.right = right
    }
}