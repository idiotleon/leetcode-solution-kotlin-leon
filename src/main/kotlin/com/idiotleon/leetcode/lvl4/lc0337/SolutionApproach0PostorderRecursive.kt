package com.idiotleon.leetcode.lvl4.lc0337

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode

/**
 * @author: Leon
 * https://leetcode.com/problems/house-robber-iii/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * Reference:
 * https://leetcode.com/problems/house-robber-iii/discuss/79330/step-by-step-tackling-of-the-problem
 */
@Suppress(UNUSED)
class SolutionApproach0PostorderRecursive {
    fun rob(root: TreeNode?): Int {
        val (skipped, robbed) = postorder(root)
        return maxOf(skipped, robbed)
    }

    private fun postorder(node: TreeNode?): RobRes {
        if (node == null) return RobRes(0, 0)

        val (lSkipped, lRobbed) = postorder(node.left)
        val (rSkipped, rRobbed) = postorder(node.right)

        val skipped = maxOf(lSkipped, lRobbed) + maxOf(rSkipped, rRobbed)
        val robbed = lSkipped + rSkipped + node.`val`

        return RobRes(skipped, robbed)
    }

    private data class RobRes(val skipped: Int, val robbed: Int)
}