/**
 * https://leetcode.com/problems/convert-bst-to-greater-tree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * References:
 *  https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247488101&idx=1&sn=6041ddda5f20ccde8a7036d3e3a1482c&chksm=9bd7ec6daca0657b2ab20a936437e2c8206384c3b1485fe91747ad796fa3a5b08556b2f4911e&scene=21#wechat_redirect
 */
package com.zea7ot.leetcode.lvl4.lc0538

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0ReversedInorderRecursive {
    private var sum = 0

    fun convertBST(root: TreeNode?): TreeNode? {
        dfs(root)
        return root
    }

    private fun dfs(node: TreeNode?) {
        if (node == null) return

        dfs(node.right)
        sum += node.`val`
        node.`val` = sum
        dfs(node.left)
    }
}