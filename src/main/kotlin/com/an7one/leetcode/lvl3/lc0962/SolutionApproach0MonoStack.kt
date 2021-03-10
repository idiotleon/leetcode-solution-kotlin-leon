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
package com.an7one.leetcode.lvl3.lc0962

import com.an7one.leetcode.util.Constant.Annotation.UNUSED
import java.util.*

@Suppress(UNUSED)
class SolutionApproach0MonoStack {
    fun maxWidthRamp(nums: IntArray): Int {
        val nNums = nums.size
        val stack = LinkedList<Int>()
        var widest = 0

        for (i in 0 until nNums) {
            if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.push(i)
            }
        }

        for (i in nNums - 1 downTo widest + 1) {
            while (stack.isNotEmpty() && nums[stack.peek()] <= nums[i]) {
                widest = maxOf(widest, i - stack.pop())
            }
        }

        return widest
    }
}