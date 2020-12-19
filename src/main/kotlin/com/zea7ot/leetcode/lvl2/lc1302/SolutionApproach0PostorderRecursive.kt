/**
 * https://leetcode.com/problems/deepest-leaves-sum/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * References:
 *
 */
package com.zea7ot.leetcode.lvl2.lc1302

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import com.zea7ot.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0PostorderRecursive {
    private var deepest = 0
    private var sum = 0

    fun deepestLeavesSum(root: TreeNode?): Int {
        if (root == null) return 0
        postorder(root, 0)
        return sum
    }

    private fun postorder(node: TreeNode?, curDepth: Int) {
        if (node == null) return

        postorder(node.left, 1 + curDepth)
        postorder(node.right, 1 + curDepth)

        if (deepest < curDepth) {
            deepest = curDepth
            sum = 0
        }

        // not an `else if` here
        if (deepest == curDepth) {
            sum += node.`val`
        }
    }
}