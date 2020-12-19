/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 *
 * Time Complexity:     O(H)
 * Space Complexity:    O(H)
 *
 * References:
 *  https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/discuss/64963/3-lines-with-O(1)-space-1-Liners-Alternatives/66601
 *  https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/discuss/64963/3-lines-with-O(1)-space-1-Liners-Alternatives
 */
package com.zea7ot.leetcode.lvl3.lc0235

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import com.zea7ot.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0BinarySearchRecursive {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?) = binarySearch(root, p, q)

    private fun binarySearch(node: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (node == null) return null
        if (p == null) return q
        if (q == null) return p

        val curVal = node.`val`
        val pVal = p.`val`
        val qVal = q.`val`

        return when {
            curVal < pVal && curVal < qVal -> binarySearch(node.right, p, q)
            curVal > pVal && curVal > qVal -> binarySearch(node.left, p, q)
            else -> node
        }
    }
}