/**
 * @author: Leon
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 *
 * pseudocode:
 *  cur = root
 *  while cur is not null
 *      if not exists cur.left
 *          visit(cur)
 *          cur = cur.right
 *      else
 *          predecessor = findInorderPredecessor(cur)
 *          if not exists predecessor.right
 *              predecessor.right = cur
 *              cur = cur.left
 *          else
 *              predecessor.right = null
 *              visit(cur)
 *              cur = cur.right
 *
 * References:
 *  https://www.youtube.com/watch?v=wGXB9OWhPTg
 *  https://github.com/mission-peace/interview/blob/master/src/com/interview/tree/MorrisTraversal.java
 */
package com.zea7ot.leetcode.lvl4.lc0230

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.utils.dataStructure.TreeNode

@Suppress(UNUSED)
class SolutionApproach0MorrisInorder {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        // sanity check
        if (root == null || k <= 0) return -1

        var cur = root
        var ith = 0

        while (cur != null) {
            if (cur.left == null) {
                if (++ith == k) return cur.`val`
                cur = cur.right
            } else {
                var predecessor = cur.left

                while (predecessor?.right != cur && predecessor?.right != null) {
                    predecessor = predecessor.right
                }

                if (predecessor?.right == null) {
                    predecessor?.right = cur
                    cur = cur.left
                } else {
                    if (++ith == k) return cur.`val`
                    predecessor.right = null;
                    cur = cur.right
                }
            }
        }

        return -1
    }
}