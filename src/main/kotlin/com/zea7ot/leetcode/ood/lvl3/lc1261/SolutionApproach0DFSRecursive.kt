/**
 * https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H) + O(N)
 *
 * References:
 *  https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/discuss/431107/JavaPython-3-DFS-clean-code-w-analysis.
 */
package com.zea7ot.leetcode.ood.lvl3.lc1261

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.utils.data_structure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0DFSRecursive(root: TreeNode?) {
    private val seen = hashSetOf<Int>()

    init {
        dfs(root, 0)
    }

    fun find(target: Int): Boolean {
        return seen.contains(target)
    }

    private fun dfs(node: TreeNode?, nodeVal: Int) {
        node?.let {
            it.`val` = nodeVal
            seen.add(nodeVal)

            dfs(it.left, 2 * nodeVal + 1)
            dfs(it.right, 2 * nodeVal + 2)
        }

        return
    }
}