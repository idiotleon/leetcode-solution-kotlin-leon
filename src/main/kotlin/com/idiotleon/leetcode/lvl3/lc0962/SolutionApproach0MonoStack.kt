package com.idiotleon.leetcode.lvl3.lc0962

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/maximum-width-ramp/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(`nNums`)
 *
 * Reference:
 * https://leetcode.com/problems/maximum-width-ramp/discuss/208348/JavaC%2B%2BPython-O(N)-Using-Stack
 * https://leetcode.com/problems/maximum-width-ramp/discuss/265765/Detailed-Explaination-of-all-the-three-approaches
 */
@Suppress(UNUSED)
class SolutionApproach0MonoStack {
    fun maxWidthRamp(nums: IntArray): Int {
        val nNums = nums.size
        val stack = ArrayDeque<Int>(nNums)
        var widest = 0

        for ((idx, num) in nums.withIndex()) {
            if (stack.isEmpty() || num < nums[stack.last()]) {
                stack.addLast(idx)
            }
        }

        for (idx in nNums - 1 downTo 1 + widest) {
            while (stack.isNotEmpty() && nums[stack.last()] <= nums[idx]) {
                widest = maxOf(widest, idx - stack.removeLast())
            }
        }

        return widest
    }
}