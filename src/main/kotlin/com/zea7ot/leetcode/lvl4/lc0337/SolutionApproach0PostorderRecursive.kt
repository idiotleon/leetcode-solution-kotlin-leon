/**
 * https://leetcode.com/problems/house-robber-iii/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * References:
 *  https://leetcode.com/problems/house-robber-iii/discuss/79330/step-by-step-tackling-of-the-problem
 */
package com.zea7ot.leetcode.lvl4.lc0337

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.utils.dataStructure.tree.TreeNode

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