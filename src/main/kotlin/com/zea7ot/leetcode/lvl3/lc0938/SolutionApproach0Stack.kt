/**
 * https://leetcode.com/problems/range-sum-of-bst/
 */
package com.zea7ot.leetcode.lvl3.lc0938

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.utils.dataStructure.tree.TreeNode
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0Stack {
    fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
        var sum = 0

        val stack = LinkedList<TreeNode>()
        stack.push(root)

        while (stack.isNotEmpty()) {
            val top = stack.pop()

            val value = top.`val`

            if (value >= low) {
                top.left?.let { stack.push(it) }
            }

            if (value <= high) {
                top.right?.let { stack.push(it) }
            }

            if (value in low..high) {
                sum += value
            }
        }

        return sum
    }
}