/**
 * @author: Leon
 * https://leetcode.com/problems/binary-tree-tilt/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.zea7ot.leetcode.lvl2.lc0563

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import com.zea7ot.leetcode.util.dataStructure.tree.TreeNode
import kotlin.math.abs

@Suppress(UNUSED)
class SolutionApproach0Postorder {
    fun findTilt(root: TreeNode?): Int {
        val sum = intArrayOf(0)
        postorder(root, sum)
        return sum[0]
    }

    private fun postorder(node: TreeNode?, sum: IntArray): Int {
        if (node == null) return 0

        val left = postorder(node.left, sum)
        val right = postorder(node.right, sum)

        sum[0] += abs(left - right)
        return node.`val` + left + right
    }
}