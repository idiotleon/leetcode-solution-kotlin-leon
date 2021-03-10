/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(N) + O(H) ~ O(H)
 *
 * References:
 *  https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/discuss/161268/C++JavaPython-One-Pass-Real-O(N)/174387
 *  https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/discuss/161268/C%2B%2BJavaPython-One-Pass-Real-O(N)
 */
package com.an7one.leetcode.lvl3.lc0889

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import com.an7one.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    fun constructFromPrePost(preorder: IntArray, postorder: IntArray): TreeNode? {
        val postorderValToIdx = HashMap<Int, Int>()
        for (idx in postorder.indices) {
            postorderValToIdx[postorder[idx]] = idx
        }

        return buildTree(
            0,
            preorder.lastIndex,
            0,
            postorder.lastIndex,
            preorder,
            postorder,
            postorderValToIdx
        )
    }

    private fun buildTree(
        idxStartPreorder: Int,
        idxEndPreorder: Int,
        idxStartPostorder: Int,
        idxEndPostorder: Int,
        preorder: IntArray,
        postorder: IntArray,
        postorderValToIdx: HashMap<Int, Int>
    ): TreeNode? {
        if (idxStartPreorder > idxEndPreorder || idxStartPostorder > idxEndPostorder) return null

        val rootValue = preorder[idxStartPreorder]
        val root = TreeNode(rootValue)
        if (1 + idxStartPreorder <= idxEndPreorder) {
            val sizeLeftSubtree = postorderValToIdx[preorder[1 + idxStartPreorder]]!! - idxStartPostorder

            root.left = buildTree(
                1 + idxStartPreorder,
                1 + idxStartPreorder + sizeLeftSubtree,
                idxStartPostorder,
                idxStartPostorder + sizeLeftSubtree,
                preorder, postorder,
                postorderValToIdx
            )

            root.right = buildTree(
                1 + idxStartPreorder + sizeLeftSubtree + 1,
                idxEndPreorder,
                idxStartPostorder + sizeLeftSubtree + 1,
                idxEndPostorder - 1,
                preorder,
                postorder,
                postorderValToIdx
            )
        }

        return root
    }
}