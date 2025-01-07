package com.idiotleon.leetcode.lvl3.lc1769

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED
import kotlin.math.abs

/**
 * @author: Leon
 * https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/
 *
 * Time Complexity:     O(`lenBs` ^ 2)
 * Space Complexity:    O(1) / O(`lenBs`)
 */
@Suppress(UNUSED)
class Solution1BrutalForce {
    fun minOperations(boxes: String): IntArray {
        val lenBs = boxes.length

        val indices = mutableListOf<Int>().also {
            for ((idx, box) in boxes.withIndex()) {
                when (box) {
                    '1' -> it.add(idx)
                    else -> {}
                }
            }
        }

        val ans = IntArray(lenBs) { 0 }
        for (idx in 0 until lenBs) {
            ans[idx] = getSum(idx, indices)
        }
        return ans
    }

    private fun getSum(idx: Int, indices: List<Int>): Int {
        var sum = 0
        for (num in indices) {
            sum += abs(idx - num)
        }
        return sum
    }
}