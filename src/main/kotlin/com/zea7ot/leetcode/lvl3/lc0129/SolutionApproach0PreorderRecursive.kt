/**
 * @author: Leon
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.zea7ot.leetcode.lvl3.lc0129

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0PreorderRecursive {
    fun sumNumbers(root: TreeNode?): Int {
        if (root == null) return 0
        if (root.left == null && root.right == null) return root.`val`

        val sum = intArrayOf(0)
        preorder(root, 0, sum)
        return sum[0]
    }

    private fun preorder(node: TreeNode?, curNum: Int, sum: IntArray) {
        if (node == null) return

        val num = curNum * 10 + node.`val`

        if (node.left == null && node.right == null) {
            sum[0] += num
            return
        }

        preorder(node.left, num, sum)
        preorder(node.right, num, sum)
    }
}