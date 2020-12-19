/**
 * https://leetcode.com/problems/next-greater-element-ii/
 *
 * Time Complexity:     O(`totalNums`)
 * Space Complexity:    O(`totalNums`)
 *
 * to maintain a "non-increasing" stack
 *  1. the contents are indexes, instead of values
 *  2. the values/elements, accessed by those indexes, are non-increasing
 */
package com.zea7ot.leetcode.lvl3.lc0503

import com.zea7ot.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0MonoStack {
    fun nextGreaterElements(nums: IntArray): IntArray {

        val totalNums = nums.size
        val ans = IntArray(totalNums) { -1 }

        val stack = LinkedList<Int>()

        var idx = 0

        while (idx < totalNums * 2) {
            while (stack.isNotEmpty() && nums[idx % totalNums] > nums[stack.peek()]) {
                ans[stack.pop()] = nums[idx % totalNums]
            }

            stack.push(idx % totalNums)
            ++idx
        }

        return ans
    }
}