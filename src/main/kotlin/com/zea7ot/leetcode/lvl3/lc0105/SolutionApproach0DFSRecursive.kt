/**
 * @author: Leon
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * Time Complexity:     O(`nNodes`)
 * Space Complexity:    O(H)
 */
package com.zea7ot.leetcode.lvl3.lc0105

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.utils.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {

        val nNodes = preorder.size

        val map = HashMap<Int, Int>()
        for (idx in inorder.indices) {
            map[inorder[idx]] = idx
        }

        return dfs(0, 0, nNodes - 1, preorder, inorder, map)
    }

    private fun dfs(idxPreorder: Int,
                    idxStartInorder: Int,
                    idxEndInorder: Int,
                    preorder: IntArray,
                    inorder: IntArray,
                    map: HashMap<Int, Int>): TreeNode? {
        val nNodes = preorder.size

        if (idxPreorder >= nNodes || idxStartInorder > idxEndInorder) return null

        val rootValue = preorder[idxPreorder]
        val root = TreeNode(rootValue)

        val idxRoot = map[rootValue]!!

        root.left = dfs(idxPreorder + 1, idxStartInorder, idxRoot - 1, preorder, inorder, map)
        root.right = dfs(idxPreorder + (idxRoot - idxStartInorder + 1), idxRoot + 1, idxEndInorder, preorder, inorder, map)

        return root
    }
}