/**
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * References:
 *
 */
package com.zea7ot.leetcode.lvl3.lc0129

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import com.zea7ot.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0PreorderRecursive {
    private var sum = 0

    fun sumNumbers(root: TreeNode?): Int {
        preorder(root, 0)
        return sum
    }

    private fun preorder(node: TreeNode?, prevNum: Int) {
        if (node == null) return

        val curNum = prevNum * 10 + node.`val`

        if (node.left == null && node.right == null) {
            sum += curNum
            // to prune here
            return
        }

        preorder(node.left, curNum)
        preorder(node.right, curNum)
    }
}