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
package com.zea7ot.leetcode.lvl3.lc0889

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.utils.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive {
    fun constructFromPrePost(preorder: IntArray, postorder: IntArray): TreeNode? {
        // not used
        // val nNodes = preorder.size

        val idxPreorder = intArrayOf(0)
        val idxPostorder = intArrayOf(0)

        return dfs(idxPreorder, preorder, idxPostorder, postorder)
    }

    private fun dfs(idxPreorder: IntArray,
                    preorder: IntArray,
                    idxPostorder: IntArray,
                    postorder: IntArray): TreeNode? {

        val rootValue = preorder[idxPreorder[0]++]

        val root = TreeNode(rootValue)

        if (rootValue != postorder[idxPostorder[0]]) {
            root.left = dfs(idxPreorder, preorder, idxPostorder, postorder)
        }

        if (rootValue != postorder[idxPostorder[0]]) {
            root.right = dfs(idxPreorder, preorder, idxPostorder, postorder)
        }

        ++idxPostorder[0]
        return root
    }
}