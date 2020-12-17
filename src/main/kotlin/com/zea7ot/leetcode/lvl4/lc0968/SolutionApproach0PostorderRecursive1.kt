/**
 * https://leetcode.com/problems/binary-tree-cameras/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * References:
 *  https://leetcode.com/problems/binary-tree-cameras/discuss/211180/JavaC++Python-Greedy-DFS/608424
 *  https://leetcode.com/problems/binary-tree-cameras/discuss/211180/JavaC%2B%2BPython-Greedy-DFS
 */
package com.zea7ot.leetcode.lvl4.lc0968

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0PostorderRecursive1 {
    private var count = 0

    fun minCameraCover(root: TreeNode?): Int {
        if (postorder(root) < 1) ++count

        return count
    }

    private fun postorder(node: TreeNode?): Int {
        if (node == null) return 2

        val leftColor = postorder(node.left)
        val rightColor = postorder(node.right)

        if (leftColor == 0 || rightColor == 0) {
            ++count
            return 1
        }

        return if (leftColor == 1 || rightColor == 1) 2 else 0
    }
}