/**
 * https://leetcode.com/problems/boundary-of-binary-tree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H) + O(N) ~ O(N)
 *
 * 1. `node.left` is a left boundary if the `node` is a left boundary
 *      `node.right` can also be a left boundary if `node` is a left boundary, and(&&) `node` has no left child
 * 2. the same applies for the right boundary
 * 3. if the `node` is a left boundary, to add it before the 2 children - preorder
 *      if the `node` is a right boundary, to add it after the 2 children - postorder
 * 4. to add all the leaves as the bottom boundary
 *
 * References:
 *  https://leetcode.com/problems/boundary-of-binary-tree/discuss/101288/java-recursive-solution-beats-94
 *  https://leetcode.com/problems/boundary-of-binary-tree/discuss/101294/Java-C%2B%2B-Clean-Code-(1-Pass-perorder-postorder-hybrid)
 */
package com.zea7ot.leetcode.lvl4.lc0545

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import com.zea7ot.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0DFS {
    fun boundaryOfBinaryTree(root: TreeNode?): List<Int> {
        val ans = mutableListOf<Int>()
        if (root == null) return ans

        ans.add(root.`val`)

        dfs(isLeftBoundary = true, isRightBoundary = false, node = root.left, res = ans)
        dfs(isLeftBoundary = false, isRightBoundary = true, node = root.right, res = ans)

        return ans
    }

    private fun dfs(
        isLeftBoundary: Boolean,
        isRightBoundary: Boolean,
        node: TreeNode?,
        res: MutableList<Int>
    ) {
        if (node == null) return

        val value = node.`val`

        if (node.left == null && node.right == null) {
            res.add(value)
            return
        }

        if (isLeftBoundary) {
            res.add(value)
        }

        dfs(isLeftBoundary, node.right == null && isRightBoundary, node.left, res)
        dfs(node.left == null && isLeftBoundary, isRightBoundary, node.right, res)

        if (isRightBoundary) {
            res.add(value)
        }
    }
}