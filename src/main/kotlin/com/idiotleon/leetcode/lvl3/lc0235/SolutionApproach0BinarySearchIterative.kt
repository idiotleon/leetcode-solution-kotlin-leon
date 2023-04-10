package com.idiotleon.leetcode.lvl3.lc0235

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode

/**
 * @author: Leon
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 *
 * Time Complexity:     O(H)
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/discuss/64963/3-lines-with-O(1)-space-1-Liners-Alternatives/66601
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/discuss/64963/3-lines-with-O(1)-space-1-Liners-Alternatives
 */
@Suppress(UNUSED)
class SolutionApproach0BinarySearchIterative {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null) return null
        if (p == null) return q
        if (q == null) return p

        var cur = root

        while (cur != null) {
            val pVal = p.`val`
            val qVal = q.`val`
            val value = cur.`val`

            cur = when {
                value < pVal && value < qVal -> cur.right
                value > pVal && value > qVal -> cur.left
                else -> return cur
            }
        }

        return null
    }
}