/**
 * https://leetcode.com/problems/distribute-coins-in-binary-tree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * References:
 *  https://leetcode.com/problems/distribute-coins-in-binary-tree/discuss/256136/Java-Recursion-REALLY-easy-to-understand!!
 */
package com.an7one.leetcode.lvl4.lc0979

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import com.an7one.leetcode.util.dataStructure.tree.TreeNode
import kotlin.math.abs

@Suppress(UNUSED)
class SolutionApproach0PostorderRecursive {
    private var moves = 0

    fun distributeCoins(root: TreeNode?): Int {
        postorder(root)
        return moves
    }

    private fun postorder(node: TreeNode?): Subtree {
        if (node == null)
            return Subtree(0, 0)

        val (leftNodes, leftCoins) = postorder(node.left)
        val (rightNodes, rightCoins) = postorder(node.right)

        moves += abs(leftNodes - leftCoins) + abs(rightNodes - rightCoins)

        return Subtree(leftNodes + rightNodes + 1, leftCoins + rightCoins + node.`val`)
    }

    private data class Subtree(val nodes: Int, val coins: Int)
}