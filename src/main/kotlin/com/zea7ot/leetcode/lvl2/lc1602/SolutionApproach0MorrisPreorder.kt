/**
 * https://leetcode.com/problems/find-nearest-right-node-in-binary-tree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 *
 * References:
 *  https://leetcode.com/problems/find-nearest-right-node-in-binary-tree/discuss/874398/Java-Morris-Preorder-Time-O(n)-Space-O(1)
 */
package com.zea7ot.leetcode.lvl2.lc1602

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import com.zea7ot.leetcode.util.dataStructure.tree.TreeNode

@Suppress(UNUSED)
class SolutionApproach0MorrisPreorder {
    fun findNearestRightNode(root: TreeNode?, u: TreeNode?): TreeNode? {
        if (root == null || u == null || root == u) return null

        var curDepth = 0
        var targetDepth = -1

        var cur = root
        while (cur != null) {
            if (cur.left == null) {
                if (cur == u) targetDepth = curDepth
                else if (targetDepth == curDepth) return cur
                cur = cur.right
                ++curDepth
            } else {
                var delta = 1
                var predecessor = cur.left
                while (predecessor!!.right != cur && predecessor.right != null) {
                    predecessor = predecessor.right
                    ++delta
                }

                if (predecessor.right == null) {
                    predecessor.right = cur

                    if (cur == u) {
                        targetDepth = curDepth
                    } else if (targetDepth == curDepth) {
                        return cur
                    }

                    cur = cur.left
                    ++curDepth
                } else {
                    predecessor.right = null
                    cur = cur.right
                    curDepth -= delta
                }
            }
        }

        return null
    }
}