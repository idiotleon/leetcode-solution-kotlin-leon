package com.idiotleon.leetcode.lvl4.lc0222

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode
import kotlin.math.pow

/**
 * https://leetcode.com/problems/count-complete-tree-nodes/
 *
 * Time Complexity:     O((lgN) ^ 2)
 * Space Complexity:    O(H)
 *
 * Reference:
 * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247485057&idx=1&sn=45a3b89a4efef236cb662d5505d7ce36&chksm=9bd7f889aca0719f4915de681f983355e187151030991ab1944494ffe4b73e484068b85eb01e&scene=21#wechat_redirect
 */
@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    fun countNodes(root: TreeNode?): Int {
        if (root == null) return 0

        var left = root
        var right = root

        var heightLeft = 0
        var heightRight = 0

        while (left != null) {
            left = left.left
            ++heightLeft
        }

        while (right != null) {
            right = right.right
            ++heightRight
        }

        if (heightLeft == heightRight) {
            return 2.0.pow(heightLeft).toInt() - 1
        }

        return 1 + countNodes(root.left) + countNodes(root.right)
    }
}