/**
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * References:
 *  https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/discuss/34782/My-recursive-Java-code-with-O(n)-time-and-O(n)-space/154363
 */
package com.zea7ot.leetcode.lvl3.lc0106

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive1 {
    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        val nNodes = postorder.size

        return dfs(nNodes - 1, 0, nNodes - 1, inorder, postorder)
    }

    private fun dfs(
        idxPostorder: Int,
        startIdxInorder: Int,
        endIdxInorder: Int,
        inorder: IntArray,
        postorder: IntArray
    ): TreeNode? {
        if (idxPostorder < 0 || startIdxInorder > endIdxInorder) return null

        val nNodes = postorder.size
        val rootValue = postorder[idxPostorder]
        val root = TreeNode(rootValue)

        var idxInorder = 0
        while (idxInorder < nNodes) {
            if (inorder[idxInorder] == rootValue) break
            ++idxInorder
        }

        root.right = dfs(idxPostorder - 1, idxInorder + 1, endIdxInorder, inorder, postorder)
        root.left =
            dfs(idxPostorder - (endIdxInorder - idxInorder + 1), startIdxInorder, idxInorder - 1, inorder, postorder)

        return root
    }
}