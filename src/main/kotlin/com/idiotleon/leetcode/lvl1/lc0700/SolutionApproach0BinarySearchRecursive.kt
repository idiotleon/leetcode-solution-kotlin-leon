/**
 * https://leetcode.com/problems/search-in-a-binary-search-tree/
 *
 * Time Complexity:     O(H)
 * Space Complexity:    O(H)
 *
 * References:
 *  https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247488128&idx=2&sn=b8fb3fd2917f9ac86127054741cd5877&chksm=9bd7ec88aca0659ee0185b657663169169493e9df2063fa4d28b38a0b4d0dd698d0301937898&scene=21#wechat_redirect
 */
package com.idiotleon.leetcode.lvl1.lc0700

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0BinarySearchRecursive {
    fun searchBST(root: TreeNode?, target: Int) = binarySearch(root, target)

    private fun binarySearch(node: TreeNode?, target: Int): TreeNode? {
        if (node == null) return null

        val value = node.`val`
        return when {
            value < target -> binarySearch(node.right, target)
            value > target -> binarySearch(node.left, target)
            else -> node
        }
    }
}