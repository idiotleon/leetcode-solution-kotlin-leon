/**
 * https://leetcode.com/problems/next-greater-element-i/
 *
 * Time Complexity:     O(`totalNums1`)
 * Space Complexity:    O(`totalNums1`)
 *
 * to maintain a strictly descreasing stack
 *  1. the contents of the stack are actual values/elements
 *  2. the elements are strickly descreasing
 */
package com.zea7ot.leetcode.lvl2.lc0496

import com.zea7ot.leetcode.util.Constant.Annotation.Companion.UNUSED
import java.util.*
import kotlin.collections.HashMap

@Suppress(UNUSED)
class SolutionApproach0MonoStack {
    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
        val totalNums1 = nums1.size

        val map = HashMap<Int, Int>()
        val stack = LinkedList<Int>()

        for (num in nums2) {
            while (stack.isNotEmpty() && stack.peek() < num) {
                map[stack.pop()] = num
            }

            stack.push(num)
        }

        val ans = IntArray(totalNums1) { -1 }
        for (i in 0 until totalNums1) {
            ans[i] = map[nums1[i]] ?: -1
        }

        return ans
    }
}