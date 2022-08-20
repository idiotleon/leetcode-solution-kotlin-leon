package com.an7one.leetcode.lvl4.lc0549

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import com.an7one.leetcode.util.dataStructure.tree.TreeNode

/**
 * @author: Leon
 * https://leetcode.com/problems/binary-tree-longest-consecutive-sequence-ii/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * Reference:
 * https://leetcode.com/problems/binary-tree-longest-consecutive-sequence-ii/discuss/101519/Neat-Java-Solution-Single-pass-O(n)/105240
 * https://leetcode.com/problems/binary-tree-longest-consecutive-sequence-ii/discuss/101519/Neat-Java-Solution-Single-pass-O(n)
 */
@Suppress(UNUSED)
class SolutionApproach0PostorderRecursive {
    fun longestConsecutive(root: TreeNode?): Int = postorder(root).longest

    private fun postorder(node: TreeNode?): Res {
        if (node == null) return Res(0, 0, 0)

        val (leftInc, leftDec, leftLongest) = postorder(node.left)
        val (rightInc, rightDec, rightLongest) = postorder(node.right)

        val curVal = node.`val`

        var inc = 1
        var dec = 1

        node.left?.let {
            val leftSubVal = it.`val`
            if (curVal - leftSubVal == 1) {
                dec = 1 + leftDec
            } else if (curVal - leftSubVal == -1) {
                inc = 1 + leftInc
            }
        }

        node.right?.let {
            val rightSubVal = it.`val`
            if (curVal - rightSubVal == 1) {
                dec = maxOf(dec, 1 + rightDec)
            } else if (curVal - rightSubVal == -1) {
                inc = maxOf(inc, 1 + rightInc)
            }
        }

        val longest = maxOf(leftLongest, rightLongest, inc + dec - 1)
        return Res(inc, dec, longest)
    }

    private data class Res(val inc: Int, val dec: Int, val longest: Int)
}