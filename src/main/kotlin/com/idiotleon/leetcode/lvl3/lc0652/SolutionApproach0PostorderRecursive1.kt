/**
 * https://leetcode.com/problems/find-duplicate-subtrees/
 *
 * Time Complexity:     O(N ^ 2)
 * Space Complexity:    O(N ^ 2) + O(H) ~ O(N ^ 2)
 *
 * References:
 *  https://leetcode.com/problems/find-duplicate-subtrees/discuss/106011/Java-Concise-Postorder-Traversal-Solution
 *  https://leetcode.com/problems/find-duplicate-subtrees/discuss/106016/O(n)-time-and-space-lots-of-analysis
 *
 *  why the inorder traversal doest not work?
 *  https://leetcode.com/problems/find-duplicate-subtrees/discuss/106011/Java-Concise-Postorder-Traversal-Solution/247483
 */
package com.idiotleon.leetcode.lvl3.lc0652

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0PostorderRecursive1 {
    private companion object {
        private const val SEPARATOR = "#"
        private const val SPLITTER = ","
    }

    fun findDuplicateSubtrees(root: TreeNode?): List<TreeNode?> {
        val memo = HashMap<String, MutableList<TreeNode>>()
        postorder(root, memo)

        val ans = mutableListOf<TreeNode>()
        for ((_, nodes) in memo) {
            if (nodes.size > 1) {
                ans.add(nodes[0])
            }
        }

        return ans
    }

    private fun postorder(
        node: TreeNode?,
        memo: HashMap<String, MutableList<TreeNode>>
    ): String {
        if (node == null) return SEPARATOR
        val left = postorder(node.left, memo)
        val right = postorder(node.right, memo)

        val hash = "${node.`val`}$SPLITTER$left$SPLITTER$right$SEPARATOR"

        memo.getOrPut(hash) { mutableListOf() }.add(node)
        return hash
    }
}