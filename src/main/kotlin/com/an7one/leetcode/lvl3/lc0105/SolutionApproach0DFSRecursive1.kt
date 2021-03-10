/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * Time Complexity:     O(N ^ 2)
 * Space Complexity:    O(H)
 *
 * References:
 *  https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247487270&idx=1&sn=2f7ad74aabc88b53d94012ceccbe51be&chksm=9bd7f12eaca078384733168971147866c140496cb257946f8170f05e46d16099f3eef98d39d9&scene=21#wechat_redirect
 */
package com.an7one.leetcode.lvl3.lc0105

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import com.an7one.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive1 {
    fun buildTree(preorder: IntArray, inorder: IntArray) =
        buildTree(0, preorder.lastIndex, 0, inorder.lastIndex, preorder, inorder)

    private fun buildTree(
        idxStartPreorder: Int, idxEndPreorder: Int,
        idxStartInorder: Int, idxEndInorder: Int,
        preorder: IntArray, inorder: IntArray
    ): TreeNode? {
        if (idxStartPreorder > idxEndPreorder) return null

        val rootValue = preorder[idxStartPreorder]
        var idxRootInorder = 0
        for (idx in idxStartInorder..idxEndInorder) {
            if (inorder[idx] == rootValue) {
                idxRootInorder = idx
                break
            }
        }

        val sizeLeftSubtree = idxRootInorder - idxStartInorder

        val root = TreeNode(rootValue)
        root.left =
            buildTree(
                idxStartPreorder + 1,
                idxStartPreorder + sizeLeftSubtree,
                idxStartInorder,
                idxRootInorder - 1,
                preorder,
                inorder
            )
        root.right =
            buildTree(
                idxStartPreorder + sizeLeftSubtree + 1,
                idxEndPreorder,
                idxRootInorder + 1,
                idxEndInorder,
                preorder,
                inorder
            )
        return root
    }
}