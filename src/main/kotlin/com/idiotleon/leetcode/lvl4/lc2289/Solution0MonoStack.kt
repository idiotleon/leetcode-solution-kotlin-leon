package com.idiotleon.leetcode.lvl4.lc2289

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/steps-to-make-array-non-decreasing/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(`nNums`)
 *
 * Reference:
 * https://leetcode.com/problems/steps-to-make-array-non-decreasing/solutions/2115834/monostack-with-counter/comments/1751810
 * https://leetcode.com/problems/steps-to-make-array-non-decreasing/solutions/2115834/monostack-with-counter/?envType=company&envId=facebook&favoriteSlug=facebook-six-months&difficulty=MEDIUM
 */
@Suppress(UNUSED)
class Solution0MonoStack {
    fun totalSteps(nums: IntArray): Int {
        val nNums = nums.size
        val stack = ArrayDeque<Node>(nNums)
        for (idx in nNums - 1 downTo 0) {
            var count = 0
            while (stack.isNotEmpty() && stack.last().num < nums[idx]) {
                count = maxOf(1 + count, stack.last().count)
                stack.removeLast()
            }
            stack.addLast(Node(count, nums[idx]))
        }

        return stack.maxBy { it.count }.count
    }

    private data class Node(val count: Int, val num: Int)
}