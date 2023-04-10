package com.idiotleon.leetcode.lvl3.lc1673

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/find-the-most-competitive-subsequence/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(`nNums`)
 */
@Suppress(UNUSED)
class SolutionApproach0MonoStack {
    fun mostCompetitive(nums: IntArray, k: Int): IntArray {
        val nNums = nums.size
        val limit = nNums - k

        val stack = ArrayDeque<Int>()
        var count = 0

        for (num in nums) {
            while (stack.isNotEmpty() && count < limit && stack.last() > num) {
                stack.removeLast()
                ++count
            }

            stack.addLast(num)
        }

        while (stack.size > k) {
            stack.removeLast()
        }

        return stack.toIntArray()
    }
}