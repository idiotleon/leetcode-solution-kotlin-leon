package com.idiotleon.leetcode.lvl2.lc2265

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import com.idiotleon.leetcode.util.dataStructure.tree.TreeNode

/**
 * @author: Leon
 * https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * Reference:
 * https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/editorial/?envType=company&envId=facebook&favoriteSlug=facebook-six-months
 */
@Suppress(UNUSED)
class Solution0PostorderRecursive {
    class Solution {
        fun averageOfSubtree(root: TreeNode?): Int {
            val ans = Ans(count = 0)
            postorder(root, ans)
            return ans.count
        }

        private fun postorder(node: TreeNode?, ans: Ans): Res {
            if (node == null) {
                return Res(0, 0)
            }

            val (leftSum, leftCount) = postorder(node.left, ans)
            val (rightSum, rightCount) = postorder(node.right, ans)

            val value = node.`val`
            val sum = leftSum + rightSum + value
            val nodeCount = leftCount + rightCount + 1

            if (value == sum / nodeCount) {
                ++ans.count
            }

            return Res(sum, nodeCount)
        }

        private data class Res(val value: Int, val count: Int)

        private data class Ans(var count: Int)
    }
}