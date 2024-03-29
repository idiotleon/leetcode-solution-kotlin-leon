package com.idiotleon.leetcode.lvl3.lc0106

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode

/**
 * @author: Leon
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(N) + O(H) ~ O(N)
 */
@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        val nNodes = inorder.size

        val inorderValToIdx = HashMap<Int, Int>()
        for (idx in inorder.indices) {
            inorderValToIdx[inorder[idx]] = idx
        }

        return dfs(nNodes - 1, 0, nNodes - 1, inorder, postorder, inorderValToIdx)
    }

    private fun dfs(
        idxPostorder: Int,
        idxStartInorder: Int,
        idxEndInorder: Int,
        inorder: IntArray,
        postorder: IntArray,
        inorderValToIdx: HashMap<Int, Int>
    ): TreeNode? {
        if (idxPostorder < 0 || idxStartInorder > idxEndInorder) return null

        val rootValue = postorder[idxPostorder]
        val root = TreeNode(rootValue)

        val idxRoot = inorderValToIdx[rootValue]!!

        root.right = dfs(idxPostorder - 1, idxRoot + 1, idxEndInorder, inorder, postorder, inorderValToIdx)
        root.left = dfs(
            idxPostorder - (idxEndInorder - idxRoot + 1),
            idxStartInorder,
            idxRoot - 1,
            inorder,
            postorder,
            inorderValToIdx
        )

        return root
    }
}