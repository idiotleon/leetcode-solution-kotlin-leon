/**
 * https://leetcode.com/problems/find-duplicate-subtrees/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(N) + O(H) ~ O(N)
 *
 * References:
 *  https://leetcode.com/problems/find-duplicate-subtrees/discuss/106011/Java-Concise-Postorder-Traversal-Solution
 *  https://leetcode.com/problems/find-duplicate-subtrees/discuss/106016/O(n)-time-and-space-lots-of-analysis
 *
 *  why the inorder traversal doest not work?
 *  https://leetcode.com/problems/find-duplicate-subtrees/discuss/106011/Java-Concise-Postorder-Traversal-Solution/247483
 */
package com.zea7ot.leetcode.lvl3.lc0652

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.utils.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0PostorderRecursive {
    private companion object {
        private const val SEPARATOR = "#"
        private const val SPLITTER = ","
    }

    fun findDuplicateSubtrees(root: TreeNode?): List<TreeNode?> {
        val map = HashMap<String, MutableList<TreeNode>>()
        postorder(root, map)

        val ans = mutableListOf<TreeNode>()
        for ((_, nodes) in map) {
            if (nodes.size > 1) {
                ans.add(nodes[0])
            }
        }

        return ans
    }

    private fun postorder(node: TreeNode?,
                          map: HashMap<String, MutableList<TreeNode>>): String {
        if (node == null) return SEPARATOR
        val left = postorder(node.left, map)
        val right = postorder(node.right, map)

        val hash = "${node.`val`}$SPLITTER$left$SPLITTER$right$SEPARATOR"

        map.getOrPut(hash) { mutableListOf() }.add(node)
        return hash
    }
}