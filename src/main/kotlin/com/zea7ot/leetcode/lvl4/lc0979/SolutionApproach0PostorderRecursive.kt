/**
 * https://leetcode.com/problems/distribute-coins-in-binary-tree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * References:
 *  https://leetcode.com/problems/distribute-coins-in-binary-tree/discuss/256136/Java-Recursion-REALLY-easy-to-understand!!
 */
package com.zea7ot.leetcode.lvl4.lc0979

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.util.dataStructure.tree.TreeNode
import kotlin.math.abs

@Suppress(UNUSED)
class SolutionApproach0PostorderRecursive {
    private var moves = 0

    fun distributeCoins(root: TreeNode?): Int {
        postorder(root)
        return moves
    }

    private fun postorder(node: TreeNode?): Subtree {
        if (node == null) return Subtree(0, 0)

        val leftSubtree = postorder(node.left)
        val rightSubtree = postorder(node.right)

        moves += abs(leftSubtree.nodes - leftSubtree.coins) + abs(rightSubtree.nodes - rightSubtree.coins)

        return Subtree(
            leftSubtree.nodes + rightSubtree.nodes + 1,
            leftSubtree.coins + rightSubtree.coins + node.`val`
        )
    }

    private data class Subtree(val nodes: Int, val coins: Int)
}