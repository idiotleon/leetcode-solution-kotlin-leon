/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
 *
 * Time Complexity:     O(`nNodes`)
 * Space Complexity:    O(H)
 *
 * References:
 *  https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/discuss/161268/C%2B%2BJavaPython-One-Pass-Real-O(N)
 *  https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/discuss/161372/Java-Python-Divide-and-Conquer-with-Explanation/179456
 *  https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/discuss/161372/Java-Python-Divide-and-Conquer-with-Explanation
 */
package com.idiotleon.leetcode.lvl3.lc0889

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive1 {
    fun constructFromPrePost(preorder: IntArray, postorder: IntArray): TreeNode? {
        // not used
        // val nNodes = preorder.size

        val idxPreorder = intArrayOf(0)
        val idxPostorder = intArrayOf(0)

        return buildTree(idxPreorder, idxPostorder, preorder, postorder)
    }

    private fun buildTree(
        idxPreorder: IntArray,
        idxPostorder: IntArray,
        preorder: IntArray,
        postorder: IntArray
    ): TreeNode? {

        val rootValue = preorder[idxPreorder[0]++]

        val root = TreeNode(rootValue)

        if (rootValue != postorder[idxPostorder[0]]) {
            root.left = buildTree(idxPreorder, idxPostorder, preorder, postorder)
        }

        if (rootValue != postorder[idxPostorder[0]]) {
            root.right = buildTree(idxPreorder, idxPostorder, preorder, postorder)
        }

        ++idxPostorder[0]
        return root
    }
}