package com.idiotleon.summary.byDataStructure.tree.binaryTree

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class TraversalInorderRecursive {
    fun traverseInorder(root: TreeNode?): List<TreeNode> {
        val ans = mutableListOf<TreeNode>()
        inorder(root, ans)
        return ans
    }

    private fun inorder(node: TreeNode?, res: MutableList<TreeNode>) {
        if (node == null) return

        inorder(node.left, res)
        res.add(node)
        inorder(node.right, res)
    }
}