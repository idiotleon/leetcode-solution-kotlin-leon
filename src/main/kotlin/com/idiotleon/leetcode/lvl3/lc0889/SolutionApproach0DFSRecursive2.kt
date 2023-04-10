/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * References:
 *  https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/discuss/161372/Java-Python-Divide-and-Conquer-with-Explanation/179456
 *  https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/discuss/161372/Java-Python-Divide-and-Conquer-with-Explanation
 */
package com.idiotleon.leetcode.lvl3.lc0889

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive2 {
    fun constructFromPrePost(preorder: IntArray, postorder: IntArray) =
        buildTree(intArrayOf(0), 0, postorder.lastIndex, preorder, postorder)

    private fun buildTree(
        idxPreorder: IntArray,
        idxStartPostorder: Int,
        idxEndPostorder: Int,
        preorder: IntArray,
        postorder: IntArray
    ): TreeNode? {

        if (idxStartPostorder > idxEndPostorder) return null

        ++idxPreorder[0]
        val rootValue = postorder[idxEndPostorder]
        val root = TreeNode(rootValue)
        if (idxStartPostorder == idxEndPostorder) return root

        var idxRootPostorder = -1
        for (idx in idxStartPostorder..idxEndPostorder) {
            if (preorder[idxPreorder[0]] == postorder[idx]) {
                idxRootPostorder = idx
                break
            }
        }

        root.left = buildTree(idxPreorder, idxStartPostorder, idxRootPostorder, preorder, postorder)
        root.right = buildTree(idxPreorder, idxRootPostorder + 1, idxEndPostorder - 1, preorder, postorder)

        return root
    }
}