/**
 * https://leetcode.com/problems/binary-search-tree-iterator/
 *
 * Time Complexities:
 *  construction:   O(H)
 *  hasNext():      O(1)
 *  next():         O(H)
 *
 * Space Complexity: O(H)
 */
package com.zea7ot.leetcode.ood.lvl3.lc0173

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import com.zea7ot.leetcode.util.dataStructure.tree.TreeNode
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0InorderIterative(root: TreeNode?) {
    private val stack = LinkedList<TreeNode>()

    init {
        pushLeft(root)
    }

    /** @return the next smallest number */
    fun next(): Int {
        val top = stack.pop()
        pushLeft(top.right)

        return top.`val`
    }

    /** @return whether we have a next smallest number */
    fun hasNext(): Boolean {
        return stack.isNotEmpty()
    }

    private fun pushLeft(node: TreeNode?) {
        var cur = node

        while (cur != null) {
            stack.push(cur)
            cur = cur.left
        }
    }
}