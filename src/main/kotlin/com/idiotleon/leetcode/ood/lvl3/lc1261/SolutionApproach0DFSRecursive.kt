package com.idiotleon.leetcode.ood.lvl3.lc1261

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode

/**
 * @author: Leon
 * https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H) + O(N)
 *
 * Reference:
 * https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/discuss/431107/JavaPython-3-DFS-clean-code-w-analysis.
 */
@Suppress(UNUSED)
class SolutionApproach0DFSRecursive(root: TreeNode?) {
    private val seen = HashSet<Int>()

    init {
        dfs(root, 0)
    }

    fun find(target: Int) = seen.contains(target)

    private fun dfs(node: TreeNode?, correctedValue: Int) {
        if (node == null) return
        seen.add(correctedValue)
        node.`val` = correctedValue
        dfs(node.left, 2 * correctedValue + 1)
        dfs(node.right, 2 * correctedValue + 2)
    }
}