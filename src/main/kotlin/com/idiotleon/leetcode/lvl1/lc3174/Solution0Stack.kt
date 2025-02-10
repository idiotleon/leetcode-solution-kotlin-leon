package com.idiotleon.leetcode.lvl1.lc3174

import com.idiotleon.leetcode.util.Constant.Annotation.UNUSED

/**
 * @author: Leon
 * https://leetcode.com/problems/clear-digits/
 *
 * Time Complexity:     O(`lenS`)
 * Space Complexity:    O(`lenS`)
 */
@Suppress(UNUSED)
class Solution0Stack {
    fun clearDigits(s: String): String {
        val lenS = s.length

        val builder = StringBuilder(lenS)
        for (ch in s) {
            if (ch in '0'..'9') {
                if (builder.isNotEmpty()) {
                    builder.deleteAt(builder.length - 1)
                }
            } else {
                builder.append(ch)
            }
        }

        return builder.toString()
    }
}