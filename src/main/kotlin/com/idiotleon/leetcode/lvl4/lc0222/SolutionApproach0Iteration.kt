package com.idiotleon.leetcode.lvl4.lc0222

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode

/**
 * @author: Leon
 * https://leetcode.com/problems/count-complete-tree-nodes/
 *
 * Time Complexity:     O()
 * Space Complexity:    O()
 *
 * Reference:
 * https://leetcode.com/problems/count-complete-tree-nodes/discuss/61958/Concise-Java-solutions-O(log(n)2)
 */
@Suppress(UNUSED)
class SolutionApproach0Iteration {
    fun countNodes(root: TreeNode?): Int {
        var count = 0
        var height = getHeight(root)

        var cur = root
        while (cur != null) {
            if (getHeight(cur.right) == height - 1) {
                count += 1 shl height
                cur = cur.right
            } else {
                count += 1 shl (height - 1)
                cur = cur.left
            }

            --height
        }

        return count
    }

    private fun getHeight(node: TreeNode?): Int {
        if (node == null) return -1
        return 1 + getHeight(node.left)
    }
}