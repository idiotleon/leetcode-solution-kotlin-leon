package com.idiotleon.leetcode.lvl3.lc1769

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/
 *
 * Time Complexity:     O(`lenBs`)
 * Space Complexity:    O(1) / O(`lenBs`)
 */
@Suppress(UNUSED)
class Solution0LinearScan {
    fun minOperations(boxes: String): IntArray {
        val lenBs = boxes.length
        val ans = IntArray(lenBs) { 0 }

        var loBalls = 0
        var hiBalls = 0
        var loMoves = 0
        var hiMoves = 0

        for (lo in 0 until lenBs) {
            ans[lo] += loMoves
            loBalls += if (boxes[lo] == '1') 1 else 0
            loMoves += loBalls

            val hi = lenBs - 1 - lo
            ans[hi] += hiMoves
            hiBalls += if (boxes[hi] == '1') 1 else 0
            hiMoves += hiBalls
        }

        return ans
    }
}