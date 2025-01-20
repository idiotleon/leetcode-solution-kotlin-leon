package com.idiotleon.leetcode.lvl2.lc2405

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/optimal-partition-of-string/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(1)
 */
@Suppress(UNUSED)
class Solution0LinearScan1 {
    fun partitionString(s: String): Int {
        val lenS = s.length

        var freqs = IntArray(26) { 0 }

        var count = 0
        for (ch in s) {
            val idxCh = ch - 'a'
            if (freqs[idxCh]++ > 0) {
                ++count
                freqs = IntArray(26) { 0 }.also {
                    it[idxCh] = 1
                }
            }
        }

        return count + 1
    }
}