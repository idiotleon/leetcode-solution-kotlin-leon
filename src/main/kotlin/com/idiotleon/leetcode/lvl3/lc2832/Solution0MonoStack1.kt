package com.idiotleon.leetcode.lvl3.lc2832

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/maximal-range-that-each-element-is-maximum-in-it/
 *
 * Time Complexity:     O(`nNums`)
 * Space Complexity:    O(`nNums`)
 */
@Suppress(UNUSED)
class Solution0MonoStack1 {
    fun maximumLengthOfRanges(nums: IntArray): IntArray {
        val nNums = nums.size
        val hiMax = IntArray(nNums) { -1 }.also {
            val stack = ArrayDeque<Int>(nNums)
            for ((idx, num) in nums.withIndex()) {
                while (stack.isNotEmpty() && num > nums[stack.last()]) {
                    val topIdx = stack.removeLast()
                    if (it[topIdx] == -1) {
                        it[topIdx] = (idx - 1)
                    }
                }
                stack.addLast(idx)
            }
            while (stack.isNotEmpty()) {
                val topIdx = stack.removeLast()
                if (it[topIdx] == -1) {
                    it[topIdx] = nNums - 1
                }
            }
        }

        val loMax = IntArray(nNums) { -1 }.also {
            val stack = ArrayDeque<Int>(nNums)
            for (idx in nNums - 1 downTo 0) {
                while (stack.isNotEmpty() && nums[idx] > nums[stack.last()]) {
                    val topIdx = stack.removeLast()
                    if (it[topIdx] == -1) {
                        it[topIdx] = (idx + 1)
                    }
                }
                stack.addLast(idx)
            }
            while (stack.isNotEmpty()) {
                val topIdx = stack.removeLast()
                if (it[topIdx] == -1) {
                    it[topIdx] = 0
                }
            }
        }

        val ans = IntArray(nNums)
        for (idx in 0 until nNums) {
            val range = hiMax[idx] - loMax[idx] + 1
            ans[idx] = range
        }

        return ans
    }
}