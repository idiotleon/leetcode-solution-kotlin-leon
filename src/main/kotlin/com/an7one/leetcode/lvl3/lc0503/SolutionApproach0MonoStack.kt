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
package com.an7one.leetcode.lvl3.lc0503

import com.an7one.leetcode.util.Constant.Annotation.UNUSED

@Suppress(UNUSED)
class SolutionApproach0MonoStack {
    @OptIn(ExperimentalStdlibApi::class)
    fun nextGreaterElements(nums: IntArray): IntArray {
        val nNums = nums.size
        val ans = IntArray(nNums) { -1 }

        val stack = ArrayDeque<Int>()

        var idx = 0

        while (idx < nNums * 2) {
            while (stack.isNotEmpty() && nums[idx % nNums] > nums[stack.last()]) {
                ans[stack.removeLast()] = nums[idx % nNums]
            }

            stack.addLast(idx % nNums)
            ++idx
        }

        return ans
    }
}