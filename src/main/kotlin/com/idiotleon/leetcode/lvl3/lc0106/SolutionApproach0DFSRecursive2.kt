package com.idiotleon.leetcode.lvl3.lc0106

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode

/**
 * @author: Leon
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 *
 * Time Complexity:     O(N ^ 2)
 * Space Complexity:    O(H)
 *
 * Reference:
 * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247487270&idx=1&sn=2f7ad74aabc88b53d94012ceccbe51be&chksm=9bd7f12eaca078384733168971147866c140496cb257946f8170f05e46d16099f3eef98d39d9&scene=21#wechat_redirect
 */
@Suppress(UNUSED)
class SolutionApproach0DFSRecursive2 {
    fun buildTree(inorder: IntArray, postorder: IntArray) =
        buildTree(0, inorder.lastIndex, 0, postorder.lastIndex, inorder, postorder)

    private fun buildTree(
        idxStartInorder: Int,
        idxEndInorder: Int,
        idxStartPostorder: Int,
        idxEndPostorder: Int,
        inorder: IntArray,
        postorder: IntArray
    ): TreeNode? {

        if (idxStartInorder > idxEndInorder) return null

        val rootValue = postorder[idxEndPostorder]
        var idxRootInorder = -1
        for (idx in idxStartInorder..idxEndInorder) {
            if (inorder[idx] == rootValue) {
                idxRootInorder = idx
                break
            }
        }

        val sizeLeftSubtree = idxRootInorder - idxStartInorder
        val root = TreeNode(rootValue)
        root.left = buildTree(
            idxStartInorder,
            idxRootInorder - 1,
            idxStartPostorder,
            idxStartPostorder + sizeLeftSubtree - 1,
            inorder,
            postorder
        )
        root.right = buildTree(
            idxRootInorder + 1,
            idxEndInorder,
            idxStartPostorder + sizeLeftSubtree,
            idxEndPostorder - 1,
            inorder,
            postorder
        )
        return root
    }
}