package com.idiotleon.leetcode.lvl3.lc0503

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/next-greater-element-ii/
 *
 * Time Complexity:     O(`totalNums`)
 * Space Complexity:    O(`totalNums`)
 *
 * To maintain a "non-increasing" stack
 * 1. The contents are indices, instead of values
 * 2. The values/elements, accessed by those indices, are non-increasing
 */
@Suppress(UNUSED)
class SolutionApproach0MonoStack {
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