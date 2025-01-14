package com.idiotleon.leetcode.lvl2.lc3223

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/minimum-length-of-string-after-operations/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(1)
 *
 * Reference:
 * https://leetcode.com/problems/minimum-length-of-string-after-operations/editorial/
 */
@Suppress(UNUSED)
class Solution0LinearScan1 {
    fun minimumLength(s: String): Int {
        val lenS = s.length
        val freqs = IntArray(26) { 0 }.also {
            for (ch in s) {
                ++it[ch - 'a']
            }
        }

        var len = 0
        for (freq in freqs) {
            if (freq == 0) {
                continue
            }
            len += if (freq % 2 == 1) {
                1
            } else {
                2
            }
        }

        return len
    }
}