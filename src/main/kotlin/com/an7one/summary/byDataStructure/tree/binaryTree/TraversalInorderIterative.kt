package com.an7one.summary.byDataStructure.tree.binaryTree

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import com.an7one.leetcode.util.dataStructure.tree.TreeNode
import java.util.*

@Suppress(UNUSED)
class TraversalInorderIterative {
    fun traverseInorder(root: TreeNode?): List<TreeNode> {
        val ans = mutableListOf<TreeNode>()

        val stack = LinkedList<TreeNode>()
        pushLeft(root, stack)

        while (stack.isNotEmpty()) {
            val top = stack.pop()
            // to check out
            ans.add(top)
            pushLeft(top.right, stack)
        }

        return ans
    }

    private fun pushLeft(node: TreeNode?, stack: LinkedList<TreeNode>) {
        var cur = node
        while (cur != null) {
            stack.push(cur)
            cur = cur.left
        }
    }
}