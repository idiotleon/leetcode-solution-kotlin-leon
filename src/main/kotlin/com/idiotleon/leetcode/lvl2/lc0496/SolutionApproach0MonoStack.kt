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
 * To maintain a strictly decreasing stack
 * 1. The contents of the stack are actual values/elements
 * 2. The elements are strictly decreasing
 */
@Suppress(UNUSED)
class SolutionApproach0MonoStack {
    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
        val nNums1 = nums1.size
        val nNums2 = nums2.size

        val numToIdx = HashMap<Int, Int>(nNums2)
        val stack = ArrayDeque<Int>(nNums2)

        for (num in nums2) {
            while (stack.isNotEmpty() && stack.last() < num) {
                numToIdx[stack.removeLast()] = num
            }

            stack.addLast(num)
        }

        val ans = IntArray(nNums1) { -1 }
        for ((idx, num1) in nums1.withIndex()) {
            ans[idx] = numToIdx[num1] ?: -1
        }

        return ans
    }
}