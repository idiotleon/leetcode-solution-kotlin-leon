/**
 * https://leetcode.com/problems/binary-tree-cameras/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * References:
 *  https://leetcode.com/problems/binary-tree-cameras/discuss/211180/JavaC++Python-Greedy-DFS/389805
 *  https://leetcode.com/problems/binary-tree-cameras/discuss/211180/JavaC%2B%2BPython-Greedy-DFS
 *  https://leetcode.com/problems/binary-tree-cameras/discuss/211180/JavaC++Python-Greedy-DFS/214923
 */
package com.idiotleon.leetcode.lvl4.lc0968

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0PostorderRecursive {
    private var count = 0

    fun minCameraCover(root: TreeNode?): Int {
        val state = postorder(root)

        if (state == State.LEAF) {
            ++count
        }

        return count
    }

    private fun postorder(node: TreeNode?): State {
        if (node == null) return State.COVERED

        val leftState = postorder(node.left)
        val rightState = postorder(node.right)

        if (leftState == State.LEAF || rightState == State.LEAF) {
            ++count
            return State.PARENT
        }

        return if (leftState == State.PARENT || rightState == State.PARENT) State.COVERED else State.LEAF
    }

    private enum class State {
        LEAF, PARENT, COVERED
    }
}