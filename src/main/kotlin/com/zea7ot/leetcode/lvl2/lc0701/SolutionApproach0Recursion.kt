/**
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * References:
 *  https://leetcode.com/problems/insert-into-a-binary-search-tree/discuss/150757/java-iterative-100/253274
 */
package com.zea7ot.leetcode.lvl2.lc0701

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.utils.dataStructure.TreeNode

@Suppress(UNUSED)
class SolutionApproach0Recursion {
    fun insertIntoBST(root: TreeNode?, `val`: Int): TreeNode? {
        if (root == null) return TreeNode(`val`)

        if (root.`val` < `val`) {
            root.right = insertIntoBST(root.right, `val`)
        } else {
            root.left = insertIntoBST(root.left, `val`)
        }

        return root
    }
}