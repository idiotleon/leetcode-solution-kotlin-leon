/**
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/
 *
 * Time Complexity:     O(lg(N))
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/insert-into-a-binary-search-tree/discuss/150757/java-iterative-100/486467
 */
package com.zea7ot.leetcode.lvl2.lc0701

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.utils.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0Iteration {
    fun insertIntoBST(root: TreeNode?, `val`: Int): TreeNode? {
        // sanity check
        if (root == null) return TreeNode(`val`)

        var cur = root
        var prev: TreeNode? = null

        while (cur != null) {
            prev = cur

            cur = if (cur.`val` < `val`) {
                cur.right
            } else {
                cur.left
            }
        }

        prev?.let {
            if (it.`val` < `val`) {
                it.right = TreeNode(`val`)
            } else {
                it.left = TreeNode(`val`)
            }
        }

        return root
    }
}