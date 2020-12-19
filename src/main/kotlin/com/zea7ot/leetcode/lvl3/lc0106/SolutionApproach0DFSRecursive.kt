/**
 * @author: Leon
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(N) + O(H) ~ O(N)
 */
package com.zea7ot.leetcode.lvl3.lc0106

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import com.zea7ot.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {

        val nNodes = inorder.size

        val map = HashMap<Int, Int>()
        for (idx in inorder.indices) {
            map[inorder[idx]] = idx
        }

        return dfs(nNodes - 1, 0, nNodes - 1, inorder, postorder, map)
    }

    private fun dfs(
        idxPostorder: Int,
        idxStartInorder: Int,
        idxEndInorder: Int,
        inorder: IntArray,
        postorder: IntArray,
        map: HashMap<Int, Int>
    ): TreeNode? {

        if (idxPostorder < 0 || idxStartInorder > idxEndInorder) return null

        val rootValue = postorder[idxPostorder]
        val root = TreeNode(rootValue)

        val idxRoot = map[rootValue]!!

        root.right = dfs(idxPostorder - 1, idxRoot + 1, idxEndInorder, inorder, postorder, map)
        root.left =
            dfs(idxPostorder - (idxEndInorder - idxRoot + 1), idxStartInorder, idxRoot - 1, inorder, postorder, map)

        return root
    }
}