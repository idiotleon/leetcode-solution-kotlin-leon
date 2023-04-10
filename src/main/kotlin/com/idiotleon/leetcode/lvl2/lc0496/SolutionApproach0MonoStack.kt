package com.idiotleon.leetcode.lvl2.lc0496

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import kotlin.collections.HashMap

/**
 * @author: Leon
 * https://leetcode.com/problems/next-greater-element-i/
 *
 * Time Complexity:     O(`nNums1`)
 * Space Complexity:    O(`nNums1`)
 *
 * to maintain a strictly decreasing stack
 *  1. the contents of the stack are actual values/elements
 *  2. the elements are strictly decreasing
 */
@Suppress(UNUSED)
class SolutionApproach0MonoStack {
    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
        val nNums1 = nums1.size
        // not used
        // val nNums2 = nums2.size

        val valToIdx = HashMap<Int, Int>()
        val stack = ArrayDeque<Int>()

        for (num in nums2) {
            while (stack.isNotEmpty() && stack.last() < num) {
                valToIdx[stack.removeLast()] = num
            }

            stack.addLast(num)
        }

        val ans = IntArray(nNums1) { -1 }
        for ((idx, num1) in nums1.withIndex()) {
            ans[idx] = valToIdx[num1] ?: -1
        }

        return ans
    }
}