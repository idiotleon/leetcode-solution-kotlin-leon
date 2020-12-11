/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * References:
 *  https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247488101&idx=1&sn=6041ddda5f20ccde8a7036d3e3a1482c&chksm=9bd7ec6daca0657b2ab20a936437e2c8206384c3b1485fe91747ad796fa3a5b08556b2f4911e&scene=21#wechat_redirect
 */
package com.zea7ot.leetcode.lvl4.lc0230

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0InorderRecursive {
    private var rank = 0
    private var ans: Int? = null

    fun kthSmallest(root: TreeNode?, k: Int): Int {
        inorder(root, k)
        return ans!!
    }

    private fun inorder(node: TreeNode?, k: Int) {
        if (node == null) return

        inorder(node.left, k)
        ++rank
        if (rank == k) {
            ans = node.`val`
            return
        }
        inorder(node.right, k)
    }
}