package com.idiotleon.leetcode.lvl4.lc0769

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/max-chunks-to-make-sorted-ii/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(`nNums`)
 *
 * Reference:
 * https://leetcode.com/problems/max-chunks-to-make-sorted-ii/discuss/135830/c%2B%2B-Using-Stack-with-O(n)-space-and-time-complexity.-With-7-lines.-4ms.-Beats-100
 */
@Suppress(UNUSED)
class SolutionApproach0MonoStack {
    fun maxChunksToSorted(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }

        val nNums = nums.size

        val stack = ArrayDeque<Int>(nNums)
        for (num in nums) {
            val curMax = if (stack.isEmpty()) {
                num
            } else {
                maxOf(stack.last(), num)
            }

            while (stack.isNotEmpty() && num < stack.last()) {
                stack.removeLast()
            }

            stack.addLast(curMax);
        }

        return stack.size
    }
}