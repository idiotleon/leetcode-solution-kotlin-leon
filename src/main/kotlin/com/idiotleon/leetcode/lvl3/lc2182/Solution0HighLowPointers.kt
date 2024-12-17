package com.idiotleon.leetcode.lvl3.lc2182

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/construct-string-with-repeat-limit/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(1) / O(`lenS`)
 *
 * Reference:
 * https://leetcode.com/problems/construct-string-with-repeat-limit/solutions/1784797/java-priority-queue-and-stack-larger-string-with-repeat-limit/comments/1275800
 */
@Suppress(UNUSED)
class Solution0HighLowPointers {
    fun repeatLimitedString(s: String, repeatLimit: Int): String {
        val lenS = s.length
        var count = 0
        val freqs = IntArray(26) { 0 }.also {
            for (ch in s) {
                ++count
                ++it[ch - 'a']
            }
        }

        val builder = StringBuilder(lenS)
        var hi = 25
        while (hi >= 0) {
            if (freqs[hi] == 0) {
                --hi
                continue
            }
            val times = minOf(freqs[hi], repeatLimit)
            builder.append((('a' + hi).toString()).repeat(times))
            freqs[hi] -= times
            if (freqs[hi] == 0) {
                --hi
                continue
            }

            var lo = hi - 1
            while (lo >= 0 && freqs[lo] == 0) {
                --lo
            }
            if (lo == -1) {
                return builder.toString()
            }

            builder.append(('a' + lo))
            --freqs[lo]
        }

        return builder.toString()
    }
}