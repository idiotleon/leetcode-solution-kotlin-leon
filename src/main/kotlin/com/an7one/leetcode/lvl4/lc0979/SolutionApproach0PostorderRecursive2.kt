/**
 * https://leetcode.com/problems/distribute-coins-in-binary-tree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * References:
 *  https://leetcode.com/problems/distribute-coins-in-binary-tree/discuss/307231/Java-Solution-(0-ms)-easy-to-understand
 */
package com.an7one.leetcode.lvl4.lc0979

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import com.an7one.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0PostorderRecursive2 {
    fun distributeCoins(root: TreeNode?): Int {
        val moves = intArrayOf(0)
        postorder(root, null, moves)
        return moves[0]
    }

    private fun postorder(cur: TreeNode?, parent: TreeNode?, moves: IntArray) {
        if (cur == null) return

        postorder(cur.left, cur, moves)
        postorder(cur.right, cur, moves)

        val value = cur.`val`

        when {
            value < 1 -> {
                moves[0] += (1 - value)
                parent!!.`val` -= (1 - value)
            }

            value > 1 -> {
                moves[0] += (value - 1)
                parent!!.`val` += value - 1
            }

            else -> {
            }
        }
    }
}