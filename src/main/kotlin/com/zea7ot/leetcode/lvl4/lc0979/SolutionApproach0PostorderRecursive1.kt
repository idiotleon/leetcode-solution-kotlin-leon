/**
 * https://leetcode.com/problems/distribute-coins-in-binary-tree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * References:
 *  https://leetcode.com/problems/distribute-coins-in-binary-tree/discuss/221939/C++-with-picture-post-order-traversal/306266
 *  https://leetcode.com/problems/distribute-coins-in-binary-tree/discuss/221939/C%2B%2B-with-picture-post-order-traversal
 */
package com.zea7ot.leetcode.lvl4.lc0979

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.util.dataStructure.tree.TreeNode
import kotlin.math.abs

@Suppress(UNUSED)
class SolutionApproach0PostorderRecursive1 {
    private var moves = 0

    fun distributeCoins(root: TreeNode?): Int {
        postorder(root)

        return moves
    }

    private fun postorder(node: TreeNode?): Int {
        if (node == null) return 0

        val leftMoves = postorder(node.left)
        val rightMoves = postorder(node.right)

        moves += abs(leftMoves) + abs(rightMoves)

        return node.`val` + leftMoves + rightMoves - 1
    }
}