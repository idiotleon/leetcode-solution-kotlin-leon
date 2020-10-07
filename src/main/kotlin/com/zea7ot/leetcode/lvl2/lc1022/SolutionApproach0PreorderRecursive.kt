/**
 * https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * References:
 *  https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/discuss/270600/Java-Simple-DFS
 */
package com.zea7ot.leetcode.lvl2.lc1022

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.utils.dataStructure.TreeNode

@Suppress(UNUSED)
class SolutionApproach0PreorderRecursive {
    fun sumRootToLeaf(root: TreeNode?): Int {
        val sum = IntArray(1) { 0 }
        preorder(root, 0, sum)
        return sum[0]
    }

    private fun preorder(node: TreeNode?, `val`: Int, sum: IntArray) {
        node?.let {
            val res = `val` shl 1 or it.`val`
            if (isLeaf(it)) sum[0] += res

            preorder(it.left, res, sum)
            preorder(it.right, res, sum)
        }
    }

    private fun isLeaf(node: TreeNode?): Boolean {
        node?.let {
            return it.left == null && it.right == null
        }

        return false
    }
}