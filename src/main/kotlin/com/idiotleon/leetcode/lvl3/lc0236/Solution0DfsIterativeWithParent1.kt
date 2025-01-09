package com.idiotleon.leetcode.lvl3.lc0236

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode

/**
 * @author: Leon
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * Reference:
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/editorial/?envType=company&envId=facebook&favoriteSlug=facebook-thirty-days
 */
@Suppress(UNUSED)
class Solution0DfsIterativeWithParent1 {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        }

        val stack = ArrayDeque<TreeNode>().also {
            it.addLast(root)
        }
        val nodeToParent = HashMap<TreeNode, TreeNode?>().also {
            it[root] = null
        }

        while (!nodeToParent.containsKey(p) || !nodeToParent.containsKey(q)) {
            val node = stack.removeLast()
            node.left?.let {
                nodeToParent[it] = node
                stack.addLast(it)
            }
            node.right?.let {
                nodeToParent[it] = node
                stack.addLast(it)
            }
        }

        var curP = p
        var curQ = q

        while (curP != curQ) {
            curP = if (curP == null) q else nodeToParent[curP]
            curQ = if (curQ == null) p else nodeToParent[curQ]
        }

        return curQ
    }
}