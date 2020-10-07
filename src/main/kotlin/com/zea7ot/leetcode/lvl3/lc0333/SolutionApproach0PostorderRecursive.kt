/**
 * https://leetcode.com/problems/largest-bst-subtree/
 *
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 *
 * References:
 *  https://leetcode.com/problems/largest-bst-subtree/discuss/78899/Very-Short-Simple-Java-O(N)-Solution
 */
package com.zea7ot.leetcode.lvl3.lc0333

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import com.zea7ot.leetcode.utils.dataStructure.TreeNode

@Suppress(UNUSED)
class SolutionApproach0PostorderRecursive {
    fun largestBSTSubtree(root: TreeNode?): Int {
        val res = postorder(root)
        return res.size
    }

    private fun postorder(node: TreeNode?): Result{
        if(node == null)
            return Result(Int.MAX_VALUE, Int.MIN_VALUE, 0)

        val left = postorder(node.left)
        val right = postorder(node.right)

        return if(node.`val` > left.max && node.`val` < right.min){
            val min = minOf(node.`val`, left.min)
            val max = maxOf(node.`val`, right.max)
            val size = left.size + right.size + 1
            Result(min, max, size)
        }else{
            val size = maxOf(left.size, right.size)
            Result(Integer.MIN_VALUE, Integer.MAX_VALUE, size)
        }
    }

    private data class Result(val min: Int, val max: Int, val size: Int)
}