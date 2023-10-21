package com.idiotleon.leetcode.lvl5.lc0315

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/
 *
 * Time Complexity:     O(`nNums` * lg(`nNums`)), O(`nNums` ^ 2) in the worst case if the BST is skewed
 * Space Complexity:    O(`nNums`)
 *
 * Reference:
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/discuss/76587/Easiest-Java-solution
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/discuss/76580/9ms-short-Java-BST-solution-get-answer-when-building-BST
 */
@Suppress(UNUSED)
class SolutionApproach1BinarySearchTree {
    fun countSmaller(nums: IntArray): List<Int> {
        val nNums = nums.size

        val ans = mutableListOf<Int>()
        if (nums.isEmpty()) return ans

        val root = TreeNode(nums.last())
        ans.add(0)

        for (idx in nNums - 2 downTo 0) {
            val count = insert(nums[idx], root)
            ans.add(count)
        }

        ans.reverse()
        return ans
    }

    private fun insert(value: Int, node: TreeNode): Int {
        var count = 0
        var cur = node

        while (true) {
            if (value <= cur.value) {
                ++cur.count
                if (cur.left == null) {
                    cur.left = TreeNode(value)
                    break
                } else {
                    cur = cur.left!!
                }
            } else {
                count += cur.count

                if (cur.right == null) {
                    cur.right = TreeNode(value)
                    break
                } else {
                    cur = cur.right!!
                }
            }
        }

        return count
    }

    private data class TreeNode(
        val value: Int, var count: Int = 1, var left: TreeNode? = null, var right: TreeNode? = null
    )
}