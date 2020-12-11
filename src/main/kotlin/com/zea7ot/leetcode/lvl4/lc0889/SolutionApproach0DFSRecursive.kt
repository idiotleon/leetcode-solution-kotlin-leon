/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *  H, height of the tree
 *
 * References:
 *  https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/discuss/161268/C%2B%2BJavaPython-One-Pass-Real-O(N)
 */
package com.zea7ot.leetcode.lvl4.lc0889

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    fun constructFromPrePost(pre: IntArray, post: IntArray): TreeNode? {
        val idxPre = intArrayOf(0)
        val idxPost = intArrayOf(0)

        return dfs(idxPre, pre, idxPost, post)
    }

    private fun dfs(idxPre: IntArray,
                    pre: IntArray,
                    idxPost: IntArray,
                    post: IntArray): TreeNode? {

        val value = pre[idxPre[0]++]

        val root = TreeNode(value)

        if (value != post[idxPost[0]]) {
            root.left = dfs(idxPre, pre, idxPost, post)
        }

        if (value != post[idxPost[0]]) {
            root.right = dfs(idxPre, pre, idxPost, post)
        }

        ++idxPost[0]
        return root
    }
}