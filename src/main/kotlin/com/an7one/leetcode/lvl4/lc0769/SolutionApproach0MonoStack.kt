/**
 * https://leetcode.com/problems/max-chunks-to-make-sorted-ii/
 *
 * Time Complexity:     O(`totalNums`)
 * Space Complexity:    O(`totalNums`)
 *
 * References:
 *  https://leetcode.com/problems/max-chunks-to-make-sorted-ii/discuss/135830/c%2B%2B-Using-Stack-with-O(n)-space-and-time-complexity.-With-7-lines.-4ms.-Beats-100
 */
package com.an7one.leetcode.lvl4.lc0769

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0MonoStack {
    fun maxChunksToSorted(nums: IntArray): Int {
        // sanity check
        if (nums.isEmpty()) return 0

        // not used
        // val totalNums = nums.size

        val stack = LinkedList<Int>()
        for (num in nums) {
            val curMax = if (stack.isEmpty()) num else maxOf(stack.peek(), num)

            while (stack.isNotEmpty() && stack.peek() > num) {
                stack.pop()
            }

            stack.push(curMax);
        }

        return stack.size
    }
}