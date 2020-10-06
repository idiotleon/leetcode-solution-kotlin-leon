/**
 * https://leetcode.com/problems/maximum-width-ramp/
 *
 * Time Complexity:     O(`totalNums`)
 * Space Complexity:    O(`totalNums`)
 *
 * References:
 *  https://leetcode.com/problems/maximum-width-ramp/discuss/208348/JavaC%2B%2BPython-O(N)-Using-Stack
 *  https://leetcode.com/problems/maximum-width-ramp/discuss/265765/Detailed-Explaination-of-all-the-three-approaches
 */
package com.zea7ot.leetcode.lvl3.lc0962

import com.zea7ot.leetcode.utils.Constant.Annotation.Companion.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0MonoStack {
    fun maxWidthRamp(nums: IntArray): Int {
        val totalNums = nums.size
        val stack = LinkedList<Int>()
        var widest = 0

        for (i in 0 until totalNums) {
            if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.push(i)
            }
        }

        for (i in totalNums - 1 downTo widest + 1) {
            while (stack.isNotEmpty() && nums[stack.peek()] <= nums[i]) {
                widest = maxOf(widest, i - stack.pop())
            }
        }

        return widest
    }
}