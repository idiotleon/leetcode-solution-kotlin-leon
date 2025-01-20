package com.idiotleon.leetcode.lvl2.lc2405

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/optimal-partition-of-string/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/optimal-partition-of-string/editorial/
 */
@Suppress(UNUSED)
class Solution0LinearScan {
    fun partitionString(s: String): Int {
        val lenS = s.length

        // indices
        val lastSeen = IntArray(26) { -1 }

        var prevStart = 0
        var count = 1
        for ((idx, ch) in s.withIndex()) {
            if (lastSeen[ch - 'a'] >= prevStart) {
                ++count
                prevStart = idx
            }
            lastSeen[ch - 'a'] = idx
        }

        return count
    }
}